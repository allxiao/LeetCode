public class Solution {
    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        int i = 1, j = 0;
        while (i < a.length) {
            if (a[i] != a[j]) {
                a[++j] = a[i];
            }
            i++;
        }
        return j + 1;
    }
}
