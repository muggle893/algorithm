public class _8下降路径最小和 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int n = minFallingPathSum(matrix);
        System.out.println(n);
    }
    public static int minFallingPathSum(int[][] matrix) {
        // 1.状态表示：dp[i][j]表示到达i, j位置的最小下降路径
        // 2.状态转移方程：dp[i][j] = min(dp[i - 1][j - 1],dp[i - 1][j], dp[i - 1][j + 1]) + matrix[x][y]
        // 3.初始化：创建比matrix多一行多两列的矩阵，然后第0行初始化为0，第0列，最后一列都初始化为正无穷
        // 4.填表顺序：一行一行从上到下从左到右填表
        // 5.返回dp表中最后一行的最小下降路径
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 2];
        int minPathNum = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1])
                        + matrix[i - 1][j - 1];
            }
        }
        for (int col = 1; col <= n; col++) {
            minPathNum = Math.min(minPathNum, dp[m][col]);
        }
        return minPathNum;
    }
}
