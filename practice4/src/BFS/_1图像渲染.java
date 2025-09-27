package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _1图像渲染 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        // 记录是否访问过，防止死循环
        boolean[][] visited = new boolean[m][n];
        // 初始像素
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            image[x][y] = color;
            // 上下左右
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a <= m - 1
                        && b >= 0 && b <= n - 1
                        && oldColor == image[a][b] && !visited[a][b]) {
                    queue.offer(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
        }
        return image;
    }
}
