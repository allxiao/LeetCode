public class Solution {
    public int removeElement(int[] a, int elem) {
        int l = 0, r = a.length;
        while (l < r) {
            if (a[l] == elem) {
                r--;
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
            }
            else {
                l++;
            }
        }
        return r;
    }
}
