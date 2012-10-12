public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0)
            return 0;
        int column = grid[0].length;
        if (column == 0)
            return 0;

        // can be optimized to use O(C) space where C=column
        int[][] sum = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0)
                    sum[i][j] = grid[i][j];
                else if (i == 0)
                    sum[i][j] = sum[i][j-1] + grid[i][j];
                else if (j == 0)
                    sum[i][j] = sum[i-1][j] + grid[i][j];
                else
                    sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[row - 1][column - 1];
    }
}
