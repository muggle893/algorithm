package code_6_15;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrace(nums, used);
        return res;
    }
    private void backtrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                int lastIndex = path.size() - 1;
                backtrace(nums, used);
                path.remove(lastIndex);
                used[i] = false;
            }
        }
    }
}
