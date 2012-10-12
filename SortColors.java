public class Solution {
    public void sortColors(int[] a) {
        int l = 0, i = 0, r = a.length - 1;
        while (i <= r) {
            if (a[i] == 0) {
                swap(a, i, l);
                i++;
                l++;
            }
            else if (a[i] == 1) {
                i++;
            }
            else {
                swap(a, i, r);
                r--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
