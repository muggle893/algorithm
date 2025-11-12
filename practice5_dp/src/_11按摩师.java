public class _11按摩师 {
    public int massage(int[] nums) {
        // 1.状态表示:用f[i]表示从下标0到i区间，选择i位置时最大的预约时长
        //   g[i]表示从0-i区间不选择i位置的时候的最大预约时长
        // 2.状态转移方程：f[i] = g[i - 1] + nums[i]
        //              g[i] = max(f[i-1], g[i-1])
        // 3.初始化f[0] = nums[0], g[0] = 0
        // 4.填表顺序：从左向右
        // 5.return max(f[n - 1], g[n - 1])
        int n = nums.length;
        if (n == 0) return 0;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = nums[i] + g[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[n - 1], g[n - 1]);
    }
}
