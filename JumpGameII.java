public class Solution {
    public int jump(int[] a) {
        if (a == null || a.length <= 1)
            return 0;
        int last = a.length - 1;
        int count = 0;
        OUTER:
        while (last > 0) {
            for (int i = 0; i < last; i++) {
                if (i + a[i] >= last) {
                    last = i;
                    count++;
                    continue OUTER;
                }
            }
            return -1;
        }
        return count;
    }
}
