public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        char first = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0, m = board.length; i < m; i++) {
            for (int j = 0, n = board[0].length; j < n; j++) {
                if (board[i][j] == first) {
                    visited[i][j] = true;
                    if (helper(board, i, j, visited, word, 1))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, boolean[][] visited, String word, int index) {
        if (index >= word.length())
            return true;
        char c = word.charAt(index);
        if (row > 0 && !visited[row-1][col] && board[row-1][col] == c) {
            visited[row-1][col] = true;
            if (helper(board, row - 1, col, visited, word, index + 1))
                return true;
            visited[row-1][col] = false;
        }
        if (row < visited.length - 1 && !visited[row+1][col] &&
            board[row+1][col] == c) {
            visited[row+1][col] = true;
            if (helper(board, row + 1, col, visited, word, index + 1))
                return true;
            visited[row+1][col] = false;
        }
        if (col > 0 && !visited[row][col-1] && board[row][col-1] == c) {
            visited[row][col-1] = true;
            if (helper(board, row, col - 1, visited, word, index + 1))
                return true;
            visited[row][col-1] = false;
        }
        if (col < visited[0].length - 1 && !visited[row][col + 1] &&
            board[row][col + 1] == c) {
            visited[row][col + 1] = true;
            if (helper(board, row, col + 1, visited, word, index + 1))
                return true;
            visited[row][col + 1] = false;
        }
        return false;
    }
}
