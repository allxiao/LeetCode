public class Solution {
    public int firstMissingPositive(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] != i + 1 && a[i] > 0 && a[i] <= a.length && a[a[i]-1] != a[i]) {
                swap(a, i, a[i] - 1);
            }
            else
                i++;
        }
        for (i = 0; i < a.length; i++)
            if (a[i] != i+1)
                break;
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
