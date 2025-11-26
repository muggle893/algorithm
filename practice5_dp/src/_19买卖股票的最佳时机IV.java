public class _19买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];
        f[0][0] = -prices[0];
        g[0][0] = 0;
        final int INT_MIN = -0x3f3f3f3f;
        for (int i = 1; i < k + 1; i++) {
            f[0][i] = g[0][i] = INT_MIN;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                f[i][j] = Math.max(f[i-1][j], g[i-1][j] - prices[i]);
                g[i][j] = g[i-1][j];
                if (j - 1 >= 0) g[i][j] = Math.max(g[i][j], f[i-1][j-1]+prices[i]);
            }
        }
        int ret = 0;
        for (int i = 0; i < k + 1; i++) {
            ret  = Math.max(ret,g[n-1][i]);
        }
        return ret;
    }
}
