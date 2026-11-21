package review.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _2全排列II {
    boolean[] visited;
    int n;
    int len = 0;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] nums;

    public static void main(String[] args) {
        _2全排列II a = new _2全排列II();
        int[] nums = new int[]{1, 1, 2};
        a.permuteUnique(nums);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        visited = new boolean[n];
        this.nums = nums;
        dfs();
        return res;
    }

    public void dfs() {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (pre == -1 || nums[pre] != nums[i]) {
                    path.addLast(nums[i]);
                    visited[i] = true;
                    // 继续选择下一个位置的元素
                    dfs();
                    visited[i] = false;
                    path.removeLast();
                    // 更新前一个元素
                    pre = i;
                }
            }
        }
    }
}
