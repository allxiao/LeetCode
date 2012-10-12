public class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length == 0) {
            return findMedianSorted(b);
        }
        if (b.length == 0) {
            return findMedianSorted(a);
        }
        int mid = a.length + (b.length - a.length) / 2;
        // restrict left/right to the range of the possible median places
        // and then j in the method has the value [-1, b.length - 1]
        return findMedianSortedArrays(a, b,
                                      Math.max(0, mid - b.length),
                                      Math.min(a.length - 1, mid));
    }

    private double findMedianSorted(int[] a) {
        if (a.length % 2 == 0)
            return (a[a.length / 2 - 1] + a[a.length / 2]) / 2.0;
        else
            return a[a.length / 2];
    }

    private double findMedianSortedArrays(int[] a, int[] b, int left, int right) {
        int mid = a.length + (b.length - a.length) / 2;
        if (left > right) {
            return findMedianSortedArrays(b, a,
                                          Math.max(0, mid - a.length),
                                          Math.min(b.length - 1, mid));
        }
        int i = left + (right - left) / 2;
        int j = (a.length + b.length) / 2 - i - 1;

        if (j >= 0 && a[i] < b[j])
            return findMedianSortedArrays(a, b, i + 1, right);
        else if (j < b.length - 1 && a[i] > b[j + 1])
            return findMedianSortedArrays(a, b, left, i - 1);
        else {
            if ((a.length + b.length) % 2 != 0)
                return a[i];
            else if (i > 0) {
                if (j >= 0)
                    return (a[i] + Math.max(a[i-1], b[j])) / 2.0;
                else
                    return (a[i] + a[i-1]) / 2.0;
            }
            else
                return (a[i] + b[j]) / 2.0;
        }
    }
}
