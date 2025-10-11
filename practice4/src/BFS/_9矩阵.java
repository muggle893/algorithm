package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _9矩阵 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int[][] updateMatrix(int[][] mat) {
        // 1 先把各个终点放入队列中
        // 2 然后用BFS去遍历，遍历到值为1的点，res[x][y] = res[a][b] + 1
        // 3 然后继续遍历直到没有新的源点
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t[0] + dx[i];
                int y = t[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = 1 + res[t[0]][t[1]];
                    q.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }
}
