public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    char[] possible = collectPossible(board, i, j);
                    for (int k = 1; k <= 9; k++) {
                        if (possible[k] == 1)
                            continue;
                        board[i][j] = (char)('0' + k);
                        if (solveSudokuHelper(board))
                            return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private char[] collectPossible(char[][] board, int row, int col) {
        char[] ret = new char[10];
        for (int i = 0; i < 9; i++)
            if (board[i][col] != '.' && i != row)
                ret[board[i][col] - '0'] = 1;
        for (int j = 0; j < 9; j++)
            if (board[row][j] != '.' && j != col)
                ret[board[row][j] - '0'] = 1;
        for (int i = row / 3 * 3, ie = i + 3; i < ie; i++) {
            for (int j = col / 3 * 3, je = j + 3; j < je; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] != '.')
                    ret[board[i][j] - '0'] = 1;
            }
        }
        return ret;
    }
}
