package code_6_18;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class 不同路径II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length; // 行
        int m = obstacleGrid[0].length; // 列
        int[][] dp = new int[n][m];

        // 初始化
        int j = 0;
        for (j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            }
            else {
                dp[0][j] = 0;
                break;
            }
        }
        if (j != m) {
            while (j < m) {
                dp[0][j] = 0;
                j++;
            }
        }
        int i = 0;
        for (i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = 0;
                break;
            }
        }
        if (i != n) {
            while (i < n) {
                dp[i][0] = 0;
                i++;
            }
        }

        // 遍历
        for (i = 1; i < n; i++) {
            for (j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
