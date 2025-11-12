public class _10地下城游戏 {
    public static void main(String[] args) {
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int n = calculateMinimumHP(arr);
        System.out.println(n);
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        // 1.状态表示：dp[i][j] 表示到i, j 位置所需的最小初始健康点数
        // sum[i][j] 表示到i, j位置时还剩的生命值
        // 2.状态方程：dp[i][j] = min(dp[i - 1][j] + 所需的生命点，dp[i][j - 1] + 所需的生命点)
        // 所需的生命点为：判断sum[i][j] + dungeon[i - 1][j - 1]是否大于等于1，如果不大于等于1就计算1 - sum[i][j] - dungeon[i][j]
        // 3.初始化，创建dp[m + 1][n + 1]和sum[m + 1][n + 1], dp[0][1]和dp[1][0]都初始化为0, sum[0][1]和sum[1][0]也是初始化为0
        // 4.填表顺序，从上到下从左到右
        // 5.return dp[m][n]
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int[][] life = new int[n + 1][m + 1]; // life的第一行和第一列都初始化为0
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            dp[0][i] = 3000000;
        }
        for (int i = 2; i <= m; i++) {
            dp[i][0] = 3000000;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int total1 = life[i - 1][j] + dungeon[i - 1][j - 1];
                int total2 = life[i][j - 1] + dungeon[i - 1][j - 1];
                int need1 = 0;
                int need2 = 0;
                if (total1 >= 1) {
                    need1 = 0;
                } else {
                    need1 = 1 - total1;
                }
                if (total2 >= 1) {
                    need2 = 0;
                } else {
                    need2 = 1 - total2;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + need1, dp[i][j - 1] + need2);
                // 更新生命值
                if (dp[i - 1][j] + need1 < dp[i][j - 1] + need2) {
                    if (total1 >= 1) {
                        life[i][j] = total1;
                    } else {
                        life[i][j] = 1;
                    }

                } else {
                    if (total2 >= 1) {
                        life[i][j] = total2;
                    } else {
                        life[i][j] = 1;
                    }
                }
            }
        }
        return dp[n][m];
    }
}
