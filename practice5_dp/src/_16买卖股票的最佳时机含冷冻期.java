public class _16买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        // 1.状态表示：dp[i][0]表示第i天后处于买入状态的最大利润
        //           dp[i][1]表示第i天后处于可交易的最大利润
        //           dp[i][2]表示第i天后处于冷冻期状态的最大利润
        // 2.状态转移方程：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
        //              dp[i][1] = max(dp[i-1][1], dp[i-1][2])
        //              dp[i][2] = dp[i-1][0] + prices[i]
        // 3.初始化：dp[0][0] = -prices[0], dp[0][1] = 0, dp[0][2] = 0
        // 4.填表顺序，从小到大dp[1]....dp[n - 1]填
        // 5.返回max(dp[n-1][0], dp[n-1][1], dp[n-2][2])
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }
        return Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}
