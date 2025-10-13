package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _11地图中的最高点 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] high = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    high[i][j] = 0;
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
                if (x >= 0 && x < m && y >= 0 && y < n && isWater[x][y] == 0 && high[x][y] == 0) {
                    high[x][y] = high[a][b] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return high;
    }
}
