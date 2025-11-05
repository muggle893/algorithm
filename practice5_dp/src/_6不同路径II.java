public class _6不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1.状态表示：dp[i][j] 表示到达下标为i和j的格子的路径数目
        // 2.状态转移方程：
        //              dp[i][j] = dp[i - 1][j] + dp[i][j - 1], grid[i][j] != 1时
        //              dp[i][j] = 0, grid[i][j]为1时
        // 3.初始化, 第一行和第一列要初始化
        // 4.填表顺序，一行一行填从左到右填
        // 5.返回dp[m - 1][n - 1]
        int m  = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
