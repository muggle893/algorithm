import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
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
                int target = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[l] + nums[r] == target){
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
