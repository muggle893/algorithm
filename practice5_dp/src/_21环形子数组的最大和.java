public class _21环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        // 状态表示：f[i]表示从0-i区间内并且以i元素作为结尾的最大子数组的和
        //         g[i]表示0-i区间内并且以i元素作为结尾的最小子数组的和
        // 状态转移方程：f[i] = max(f[i-1] + nums[i], nums[i])
        //             g[i] = min(g[i-1] + nums[i], nums[i]), 这里的i-1可能变为-1所以要特殊处理
        int n = nums.length;
        if (n ==1) return nums[0];
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        int sum = 0;
        int gMin = Integer.MAX_VALUE;
        int fMax = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            f[i] = Math.max(nums[i - 1], f[i - 1] + nums[i - 1]);
            fMax = Math.max(fMax, f[i]);
            g[i] = Math.min(g[i - 1] + nums[i - 1], nums[i - 1]);
            gMin = Math.min(gMin, g[i]);
        }
        return sum == gMin ? fMax : Math.max(fMax, sum - gMin);
    }
}
