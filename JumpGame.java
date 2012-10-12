public class Solution {
    public boolean canJump(int[] a) {
        if (a == null || a.length <= 1)
            return true;
        int last = a.length - 1;
        while (last > 0) {
            boolean found = false;
            for (int i = 0; i < last; i++) {
                if (i + a[i] >= last) {
                    last = i;
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }
}
