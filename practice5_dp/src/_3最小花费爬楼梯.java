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

    // 另外一种解法，dp[i]表示下标为i的台阶到下标为n的台阶
    public int minCostClimbingStairs3(int[] cost) {
        // 1. 状态转移方程为：dp[i] = min(dp[i + 1] + cost[i + 1], dp[i + 2] + cost[i + 2])
        // 2. 初始化dp[n -1] = cost[n - 1], dp[n - 2] = cost[n - 2]
        // 3. 填表顺序从右往左填表
        // 4. 返回min(dp[0], dp[1])
        int n = cost.length;
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1] + cost[i + 1], dp[i + 2] + cost[i + 2]);
        }
        if (dp[0] > dp[1]) {
            return dp[1];
        }
        return dp[0];
    }
}
