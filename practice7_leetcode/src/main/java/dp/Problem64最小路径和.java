package dp;

import java.util.Arrays;

public class Problem64最小路径和 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int MAX = 0x3f3f3f3f;
        // 初始化
        Arrays.fill(dp[0], MAX);
        for (int row = 0; row <= n; row++) {
            dp[row][0] = MAX;
        }
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
