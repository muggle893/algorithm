public class _5不同路径 {
    public int uniquePaths(int m, int n) {
        // 1. 状态表示：dp[i][j]表示到下标为i,j的格子的路径数目
        // 2. 状态转移方程：dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        // 3. 初始化dp[0][j] = 1, dp[i][0] = 1
        // 4. 填表顺序，从下标为1的行开始填表
        // 5. 最后返回dp[m-1][n-1]
        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
