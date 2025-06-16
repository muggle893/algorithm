package code_6_15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class N皇后 {
    List<List<String>> res = new ArrayList<>();
    @Test
    public void test() {
        List<List<String>> li = solveNQueens(4);
        for (List<String> l : li) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println("------------");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //初始化棋盘, 字符Q表示皇后，字符N表示空位，字符.表示放入皇后之后不允许放皇后的位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrace(n, 0, board);
        return res;
    }
    public void backtrace(int n, int rowIndex, char[][] board) {
        if (n == rowIndex) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(new String(board[i]));
            }
            res.add(path);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, n, rowIndex, col)) {
                board[rowIndex][col] = 'Q';
                backtrace(n, rowIndex + 1, board);
                board[rowIndex][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int n, int row, int col) {
        // 检查行
        for (int j = 0; j < n && j != col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // 检查列
        for (int i = 0; i < n && i != row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查主对角线
        int i = row, j = col;
        while (i - 1 >= 0 && j - 1 >= 0) {
            if (board[i - 1][j - 1] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i + 1 < n && j + 1 < n) {
            if (board[i + 1][j + 1] == 'Q') {
                return false;
            }
            i++;
            j++;
        }
        // 检查副对角线
        i = row;
        j = col;
        while (i - 1 >= 0 && j + 1 < n) {
            if (board[i - 1][ j + 1] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i + 1 < n && j - 1 >= 0) {
            if (board[i + 1][j - 1] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
