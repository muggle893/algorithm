package prefixsun;

public class _6矩阵区域和 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                if (j - 1 >= 0) {
                    tmp += sum[i][j - 1];
                }
                if (i - 1 >= 0) {
                    tmp += sum[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    tmp -= sum[i - 1][j - 1];
                }
                tmp += mat[i][j];
                sum[i][j] = tmp;
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 先将区域变成一个合法区域再计算区域的和
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m - 1, i + k);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n - 1, j + k);
                // 计算和
                res[i][j] = sum[r2][c2];
                if (r1 - 1 >= 0 && c1 - 1 >= 0) {
                    res[i][j] += sum[r1 - 1][c1 - 1];
                }
                if (c1 - 1 >= 0) {
                    res[i][j] -= sum[r2][c1 - 1];
                }
                if (r1 - 1 >= 0) {
                    res[i][j] -= sum[r1 - 1][c2];
                }
            }
        }
        return res;
    }
}
