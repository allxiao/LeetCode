public class Solution {
    public int totalNQueens(int n) {
        if (n == 0)
            return 0;
        int[] count = new int[1];
        int[] columns = new int[n];
        totalHelper(columns, 0, count);
        return count[0];
    }

    private void totalHelper(int[] columns, int row, int[] count) {
        if (row == columns.length) {
            count[0]++;
            return;
        }
        for (int i = 0; i < columns.length; i++) {
            if (isSafe(columns, row, i)) {
                columns[row] = i;
                totalHelper(columns, row + 1, count);
            }
        }
    }

    private boolean isSafe(int[] columns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == columns[i])
                return false;
            if (Math.abs(row - i) == Math.abs(col - columns[i]))
                return false;
        }
        return true;
    }
}
