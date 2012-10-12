import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        Arrays.sort(s);
        int[] picked = new int[s.length];
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        subsetsHelper(s, 0, picked, 0, results);
        return results;
    }

    private void subsetsHelper(int[] s, int index, int[] picked, int pidx, ArrayList<ArrayList<Integer>> results) {
        if (index >= s.length) {
            ArrayList<Integer> set = new ArrayList<Integer>();
            for (int i = 0; i < pidx; i++)
                set.add(picked[i]);
            results.add(set);
            return;
        }
        subsetsHelper(s, index + 1, picked, pidx, results);
        picked[pidx] = s[index];
        subsetsHelper(s, index + 1, picked, pidx + 1, results);
    }
}
