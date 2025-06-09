package code_6_9;

import java.util.ArrayList;
import java.util.List;

public class _子集 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        res.add(0, new ArrayList<>());
        return res;
    }

    private void backtrace(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 更新path
            path.add(nums[i]);
            int lastIndex = path.size() - 1;
            // 放入结果集
            res.add(new ArrayList<>(path));
            backtrace(nums, i + 1);
            path.remove(lastIndex);
        }
    }
}
