package review.part4;

import java.util.Arrays;
import java.util.LinkedList;

public class _1找出所有子集的异或总和再求和 {
    int res = 0;
    int xorsum = 0;
    int[] nums;
    int n;
    LinkedList<Integer> path = new LinkedList<>();
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dfs(0);
        return res;
    }

    public void dfs(int cur) {
       if (cur == n) {
           return;
       }
       for (int i = cur; i < n; i++) {
           path.addLast(nums[i]);
           xorsum ^= nums[i];
           res += xorsum;
           System.out.println(Arrays.toString(path.toArray()));
           dfs(i + 1);
           xorsum ^= nums[i];
           path.removeLast();
       }
    }
}
