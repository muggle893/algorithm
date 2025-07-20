import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int prevNum = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] == prevNum) {
                continue;
            } else {
                int[] arr = Arrays.copyOfRange(nums, i + 1, nums.length);
                List<List<Integer>> threeSumList = threeSum(arr, target - nums[i]);
                for(List<Integer> list : threeSumList) {
                    list.add(nums[i]);
                    res.add(list);
                }
                // 更新前一个数
                prevNum = nums[i];
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, long target) {
        List<List<Integer>> res = new ArrayList<>();
        // 1.排序
        Arrays.sort(nums);
        int prevNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (prevNum == nums[i]) {
                continue;
            } else {
                int l = i + 1;
                int r = nums.length - 1;
                long total = target - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] > total) {
                        r--;
                    } else if (nums[l] + nums[r] == total){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                        // 进行去重操作
                        while (l < r) {
                            l++;
                            if (nums[l] != nums[l - 1]) {
                                break;
                            }
                        }
                        while (r > l) {
                            r--;
                            if (nums[r] != nums[r + 1]) {
                                break;
                            }
                        }
                    } else {
                        l++;
                    }
                }

                // 更新prevNum
                prevNum = nums[i];
            }
        }
        return res;
    }
}
