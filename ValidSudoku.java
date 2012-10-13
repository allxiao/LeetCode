import java.util.Arrays;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            //Arrays.fill(visited, false);
            visited = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0';
                    if (visited[index])
                        return false;
                    visited[index] = true;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            //Arrays.fill(visited, false);
            visited = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0';
                    if (visited[index])
                        return false;
                    visited[index] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            //Arrays.fill(visited, false);
            visited = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int r = i / 3 * 3 + j / 3;
                int c = i % 3 * 3 + j % 3;
                if (board[r][c] != '.') {
                    int index = board[r][c] - '0';
                    if (visited[index])
                        return false;
                    visited[index] = true;
                }
            }
        }
        return true;
    }
}
