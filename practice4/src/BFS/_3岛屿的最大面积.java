package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _3岛屿的最大面积 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        _3岛屿的最大面积 岛屿的最大面积 = new _3岛屿的最大面积();
        岛屿的最大面积.maxAreaOfIsland(arr);
        System.out.println(岛屿的最大面积.maxArea);

    }
    int maxArea = 0;
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        // 遍历矩阵，对全部的岛屿面积进行统计，找出面积最大的一个岛屿
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果遍历岛屿并且没有被访问过就去统计岛屿的面积
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j);
                }
            }
        }
        return maxArea;
    }

    public void bfs(int[][] grid, int i, int j) {
        int curArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        curArea++;
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = t[0] + dx[k];
                int y = t[1] + dy[k];
                if (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1
                        && !visited[x][y] && grid[x][y] == 1) {
                   visited[x][y] = true;
                   curArea++;
                   queue.offer(new int[]{x, y});
                }
            }
        }
        // 更新最大岛屿面积
        maxArea = Math.max(curArea, maxArea);
    }
}
