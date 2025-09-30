package BFS;

import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;

public class _5迷宫中离入口最近的出口 {
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int nearestExit(char[][] maze, int[] entrance) {
        // 创建visited数组
        int m = maze.length;
        int n = maze[0].length;
        int step = 0;
        visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            step++;
            for (int i = 0; i < sz; i++) {
                int[] t = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = t[0] + dx[j];
                    int y = t[1] + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.' && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                        // 判断是否到边缘出口
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return step;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
