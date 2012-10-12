import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return results;
        int n = matrix[0].length;
        if (n == 0)
            return results;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++)
                results.add(matrix[top][j]);
            for (int i = top + 1; i <= bottom; i++)
                results.add(matrix[i][right]);
            if (top != bottom)
                for (int j = right - 1; j >= left; j--)
                    results.add(matrix[bottom][j]);
            if (left != right)
                for (int i = bottom - 1; i > top; i--)
                    results.add(matrix[i][left]);
            left++;
            right--;
            top++;
            bottom--;
        }
        return results;
    }
}
