public class _18买卖股票的最佳时机III {
    // 1.状态表示：f[i][j]表示在第i天后，完成j笔交易，处于买入状态的最大利润
    //           g[i][j]表示在第i天后，完成j笔交易，处于卖出状态的最大利润
    // 2.状态转移方程：
    // f[i][j] = max(f[i-1][j], g[i-1][j] - price[i])
    // g[i][j] = max(f[i-1][j-1]+prices[i], g[i-1][j])
    // 处理计算g[i][j]的时候f[i-1][j-1]中的j-1越界问题
    // 变成g[i][j] = g[i-1][j]
    // if (j-1 >= 0) g[i][j] = max(g[i][j], f[i-1][j-1]+p[i])
    // 3.初始化：f[0][0] = -prices[0], g[0][0] = 0，第0行的其余元素初始化为INT_MIN
    // 这里的INT_MIN设为0x3f3f3f3f
    // 4.填表顺序：从上到下从左到右
    // 5.返回max(f[n-1][2]g[n-1][2])
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        int[][] g = new int[n][3];
        f[0][0] = -prices[0];
        g[0][0] = 0;
        final int INT_MIN = -0x3f3f3f3f;
        for (int i = 1; i < 3; i++) {
            f[0][i] = g[0][i] = INT_MIN;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Math.max(f[i-1][j], g[i-1][j] - prices[i]);
                g[i][j] = g[i-1][j];
                if (j - 1 >= 0) g[i][j] = Math.max(g[i][j], f[i-1][j-1]+prices[i]);
            }
        }
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            ret  = Math.max(ret,g[n-1][i]);
        }
        return ret;
    }
}
