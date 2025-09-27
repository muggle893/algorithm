package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _2岛屿数量 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        // 使用FloodFill算法，统计每一个岛屿，然后加起来
        // 遍历这个矩阵，当元素是陆地并且说没有被访问过，才使用FloodFill算法
        // 遍历完成后返回岛屿数量即可
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    floodFill(grid, visited,i, j);
                }
            }
        }
        return cnt;
    }

    // 用宽搜去覆盖岛屿，并且用visited去标记陆地是否被访问过
    public void floodFill(char[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a <= m - 1 && b >= 0 && b <= n - 1 && grid[a][b] == '1' && !visited[a][b]) {
                    visited[a][b] = true;
                    queue.offer(new int[]{a, b});
                }
            }
        }
    }
}
