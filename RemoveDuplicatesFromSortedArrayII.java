public class Solution {
    public int removeDuplicates(int[] a) {
        if (a.length <= 2)
            return a.length;
        int i = 2, j = 1;
        while (i < a.length) {
            if (a[i] != a[j] || a[i] != a[j-1]) {
                a[++j] = a[i];
            }
            i++;
        }
        return j + 1;
    }
}
