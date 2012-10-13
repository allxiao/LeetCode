import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private class PosVal {
        int pos;
        int val;
        public PosVal(int p, int v) {
            pos = p;
            val = v;
        }
    }
    
    public int[] twoSum(int[] numbers, int target) {
        PosVal[] vals = new PosVal[numbers.length];
        for (int i = 0; i < vals.length; i++)
            vals[i] = new PosVal(i+1, numbers[i]);
        Arrays.sort(vals, new Comparator<PosVal>() {
                public int compare(PosVal l, PosVal r) {
                    // overflow/underflow !!
                    return l.val - r.val;
                }
            });
        int left = 0, right = vals.length - 1;
        while (left < right) {
            int sum = vals[left].val + vals[right].val;
            if (sum == target) {
                int pos1 = vals[left].pos;
                int pos2 = vals[right].pos;
                if (pos1 > pos2)
                    return new int[] { pos2, pos1 };
                else
                    return new int[] { pos1, pos2 };
            }
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[2];
    }
}
