package code_6_15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 全排列II {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrace(nums, used);
        return res;
    }
    private void backtrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            // 收集结果，并结束递归
            res.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) || used[i]) {
                continue;
            }
            else {
                set.add(nums[i]);
                path.add(nums[i]);
                used[i] = true;
                int lastIndex = path.size() - 1;
                backtrace(nums, used);
                used[i] = false;
                path.remove(lastIndex);
            }
        }
    }
}
