public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        int start = 0, end = m - 1;
        int[] found = null;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                found = matrix[mid];
                break;
            }
            else if (matrix[mid][0] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (found == null)
            return false;
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (found[mid] == target)
                return true;
            else if (found[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
