public class _3最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n  = cost.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    // 优化后的版本
    public int minCostClimbingStairs2(int[] cost) {
        int n  = cost.length;
        if (n <= 1) {
            return 0;
        }
        int a = 0;
        int b = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = tmp;
        }
        return b;
    }
}
