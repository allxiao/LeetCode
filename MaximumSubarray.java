public class Solution {
    public int maxSubArray(int[] a) {
        int max = a[0];
        int cmax = a[0];
        for (int i = 1; i < a.length; i++) {
            if (cmax < 0)
                cmax = 0;
            cmax += a[i];
            if (cmax > max)
                max = cmax;
        }
        return max;
    }

    public int maxSubArrayDQ(int[] a) {
        return maxSubArray(a, 0, a.length - 1);
    }

    private int maxSubArray(int[] a, int l, int u) {
        if (l > u)
            return Integer.MIN_VALUE;
        if (l == u)
            return a[l];
        int m = l + (u - l) / 2;
        int lmax = a[m], rmax = a[m], sum = 0;
        for (int i = m; i >= l; i--) {
            sum += a[i];
            if (sum > lmax)
                lmax = sum;
        }
        sum = 0;
        for (int i = m; i <= u; i++) {
            sum += a[i];
            if (sum > rmax)
                rmax = sum;
        }
        int res = Math.max(maxSubArray(a, l, m - 1), maxSubArray(a, m + 1, u));
        return Math.max(res, lmax + rmax - a[m]);
    }
}
