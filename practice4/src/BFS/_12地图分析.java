package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _12地图分析 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0];
            int b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && dist[x][y] == 0) {
                    dist[x][y] = dist[a][b] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        int maxDis = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dist[i][j] > 0 && dist[i][j] > maxDis) {
                    maxDis = dist[i][j];
                }
            }
        }
        if (maxDis == Integer.MIN_VALUE) {
            return -1;
        }
        return maxDis;
    }
}
