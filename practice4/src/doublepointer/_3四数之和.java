package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int p = 0;
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        while (p <= n - 4) {
            // 利用三指针算法得到不重复的三元组
            int[] subArray = Arrays.copyOfRange(nums, p + 1, n);
            long t = target - nums[p];
            List<List<Integer>> threeSumList = threeSum(subArray, t);
            for (List<Integer> threeNums: threeSumList) {
                threeNums.add(0, nums[p]);
                res.add(threeNums);
            }
            // 更新p指针，p指针指向第一个数字
            p++;
            while (p <= n - 4 && nums[p] == nums[p - 1]) {
                p++;
            }
        }
        return res;
    }

    public  List<List<Integer>> threeSum(int[] nums, long t) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // 因为元祖的下标我们可以设为i < j < k，所以可以固定i从j~k的区间中找j < k的二元组
        int n = nums.length;
        int i = 0;
        int j = i + 1;
        int k = n - 1;

        // 如果剩下的元素不足三个那么就结束循环
        while ((k - i + 1) >= 3) {
            // 执行双指针算法，从j~k区间中找二元组
            long target = t - nums[i];
            while (j < k) {
                int s = nums[j] + nums[k];
                if (s == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    // 更新变量(注意越界问题)
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    if (j == k) {
                        break;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                    if (j == k) {
                        break;
                    }
                } else if (s > target) {
                    k--;
                } else {
                    j++;
                }
            }

            // 更新i, j, k，i指针遇到重复的元素就要跳过, 利用while中的条件来判断是否跳出循环
            i++;
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            j = i + 1;
            k = n - 1;
        }
        return res;
    }
}
