package code_6_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90_子集II {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    @Test
    public void test() {
        int[] arr = {1,2,2};
        List<List<Integer>> li = subsetsWithDup(arr);
        for (List<Integer> subLi : li) {
            for (Integer e : subLi) {
                System.out.print(e);
            }
            System.out.println();
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtrace(nums, 0, used);
        return res;
    }

    private void backtrace(int[] nums, int startIndex, boolean[] used) {
        // 收集结果
        res.add(new ArrayList<>(path));
        // 递归返回
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            int lastIndex = path.size() - 1;
            backtrace(nums, i + 1, used);
            path.remove(lastIndex);
            used[i] = false;
        }
    }
}
