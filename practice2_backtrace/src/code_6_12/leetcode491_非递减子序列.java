package code_6_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode491_非递减子序列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    @Test
    public void test() {
        int[] arr = {4,4,3,2,1};
        findSubsequences(arr);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrace(nums, 0);
        return res;
    }
    private void backtrace(int[] nums, int startIndex) {
        // 收集结果
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (startIndex == nums.length) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 数层去重
            if (i > 0 && set.contains(nums[i])) {
                continue;
            }
            // 树枝去重
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            int lastIndex = path.size() - 1;
            backtrace(nums, i + 1);
            path.remove(lastIndex);
        }
    }
}
