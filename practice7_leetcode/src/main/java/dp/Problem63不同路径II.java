package dp;

public class Problem63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        // dp[i][j]表示走到i,j位置的不同路径总数
        // i, j位置不是障碍物的情况: dp[i][j] = dp[i][j - 1] + dp[i - 1][j],
        // i, j位置是障碍物的情况: dp[i][j] = 0;
        // 初始化
        dp[0][1] = 1;

        // 填表
        for (int i = 1;i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
