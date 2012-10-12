public class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int right = m + n;
        while (n > 0 && m > 0) {
            if (b[n-1] > a[m-1])
                a[--right] = b[--n];
            else
                a[--right] = a[--m];
        }
        while (n > 0)
            a[--right] = b[--n];
    }
}
