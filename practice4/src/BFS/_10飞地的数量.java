package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _10飞地的数量 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int numEnclaves(int[][] grid) {
        // 1 将边缘的且值为1的单元格作为源点
        // 2 将dist矩阵初始化为-1
        // 3 当遇到层序遍历到陆地的时候，说明这块陆地可以离开网格边界，将dist[x][y]设置为1
        // 4 统计网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量, 并返回
        int m = grid.length;
        int n = grid[0].length;
        int[][] visit = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                q.offer(new int[]{0, col});
                visit[0][col] = 1;
            }
            if (grid[m - 1][col] == 1) {
                q.offer(new int[]{m - 1, col});
                visit[m - 1][col] = 1;
            }
        }
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1) {
                q.offer(new int[]{row, 0});
                visit[row][0] = 1;
            }
            if (grid[row][n - 1] == 1) {
                q.offer(new int[]{row, n - 1});
                visit[row][n - 1] = 1;
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0];
            int b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && visit[x][y] == 0) {
                    q.offer(new int[]{x, y});
                    visit[x][y] = 1;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visit[i][j] == 0) {
                    total++;
                }
            }
        }
        return total;
    }
}
