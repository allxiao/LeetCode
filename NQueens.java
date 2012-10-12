import java.util.ArrayList;

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> results = new ArrayList<String[]>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        solveHelper(board, 0, results);
        return results;
    }

    private void solveHelper(char[][] board, int row, ArrayList<String[]> results) {
        int n = board.length;
        if (row == n) {
            String[] lines = new String[n];
            for (int i = 0; i < n; i++)
                lines[i] = new String(board[i]);
            results.add(lines);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                solveHelper(board, row + 1, results);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int i = row, j = col;
        while (--i >= 0) {
            if (board[i][col] == 'Q')
                return false;
        }
        i = row;
        j = col;
        while (--i >= 0 && --j >= 0) {
            if (board[i][j] == 'Q')
                return false;
        }
        i = row;
        j = col;
        while (--i >= 0 && ++j < board[0].length) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
