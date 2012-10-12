public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0)
            n = 0;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int k = 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++)
                matrix[top][j] = k++;
            for (int i = top + 1; i <= bottom; i++)
                matrix[i][right] = k++;
            if (top != bottom)
                for (int j = right - 1; j >= left; j--)
                    matrix[bottom][j] = k++;
            if (left != right)
                for (int i = bottom - 1; i > top; i--)
                    matrix[i][left] = k++;
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
