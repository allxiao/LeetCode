public class Solution {
    public int sqrt(int x) {
        if (x <= 1)
            return x;
        int start = 1, end = x / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long)mid * mid;
            if (square == x)
                return mid;
            else if (square < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start - 1;
    }
}
