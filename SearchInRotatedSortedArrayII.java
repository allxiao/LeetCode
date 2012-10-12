public class Solution {
    public boolean search(int[] a, int target) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == target)
                return true;
        return false;
    }
}
