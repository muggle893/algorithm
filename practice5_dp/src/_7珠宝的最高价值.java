public class _7珠宝的最高价值 {
    public int jewelleryValue(int[][] frame) {
        // 1.状态标识；dp[i][j]表示到达i, j位置上拿取的珠宝的最大价值
        // 2.状态方程：dp[i][j] = max(dp[i-1][j] + frame[i - 1][j], dp[i][j-1] + frame[i][j-1])
        // 3.初始化：将dp表多创建一行和一列，第0行和第0列初始化为0就行
        // 4.填表顺序，一行一行填
        // 5.返回dp[m][n]
        int m = frame.length;
        int n = frame[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = i - 1;
                int y = j - 1;
                dp[i][j] = Math.max(dp[i - 1][j] + frame[x][y],dp[i][j - 1] + frame[x][y]);
            }
        }
        return dp[m][n];
    }
}
