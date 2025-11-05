public class _9最小路径和 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        int n = minPathSum(grid);
        System.out.println(n);
    }
    public static int minPathSum(int[][] grid) {
        // 1.状态表示：dp[i][j]表示到i, j位置的最小路径和
        // 2.状态方程：dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid中对应的值
        // 3.初始化：创建m + 1, n + 1的矩阵，行标为0的元素初始化0, 列标为0的元素初始化为正无穷
        // 4.填表顺序，从上到下，从左到右
        // 5.返回dp[m][n]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 0;
        for (int col = 2; col <= n; col++) {
            dp[0][col] = Integer.MAX_VALUE;
        }
        for (int row = 1; row <= m; row++) {
            dp[row][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
