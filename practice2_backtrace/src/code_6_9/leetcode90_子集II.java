package code_6_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90_子集II {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrace(nums, 0, used);
        res.add(0, new ArrayList<>());
        return res;
    }

    private void backtrace(int[] nums, int startIndex, boolean[] used) {
        // 递归返回
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            used[i] = true;
            int lastIndex = path.size() - 1;
            backtrace(nums, i + 1, used);
            path.remove(lastIndex);
            used[i] = false;
        }
    }
}
