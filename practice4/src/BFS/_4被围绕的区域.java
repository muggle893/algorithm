package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _4被围绕的区域 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        _4被围绕的区域 被围绕的区域 = new _4被围绕的区域();
        char[][] arr = {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};

        被围绕的区域.solve(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 对没被围绕的区域进行标记为*
        // 然后再遍历整个矩阵将O改为X, 将*改为O
        for (int col = 0; col < n; col++) {
            int row = 0;
            if (board[row][col] == 'O') {
                bfs(board, row, col);
            }
        }
        for (int col = 0; col < n; col++) {
            int row = m - 1;
            if (board[row][col] == 'O') {
                bfs(board, row, col);
            }
        }
        for (int row = 0; row < m; row++) {
            int col = 0;
            if (board[row][col] == 'O') {
                bfs(board, row, col);
            }
        }
        for (int row = 0; row < m; row++) {
            int col = n - 1;
            if (board[row][col] == 'O') {
                bfs(board, row, col);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int m = board.length;
        int n = board[0].length;
        board[i][j] = '*';
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int a = t[0];
            int b = t[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    queue.offer(new int[]{x, y});
                    board[x][y] = '*';
                }
            }
        }
    }
}
