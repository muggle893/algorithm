package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    public static  List<List<Integer>> threeSum(int[] nums) {
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
            int target = -nums[i];
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
