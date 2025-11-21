public class _17买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        // 两个状态：第i天后处于买入状态的最大利润，第i天后处于可交易状态的最大利润
        // dp[i][0]表示第i天后处于买入状态的最大利润
        // dp[i][1]表示第i天后处于可交易状态的最大利润
        // dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
        // dp[i][1] = max(dp[i-1][0] + prices[i] - fee, dp[i-1][1])
        // 初始化：dp[0][0] = -prices[0], dp[0][1] = 0
        // 填表顺序：从左到右
        // 返回max(dp[n-1][0], dp[n-1][1])
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
