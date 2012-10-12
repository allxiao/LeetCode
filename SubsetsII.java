import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int[] picked = new int[num.length];
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        subsetsWithDupHelper(num, 0, picked, 0, results);
        return results;
    }

    private void subsetsWithDupHelper(int[] num, int index, int[] picked, int pidx, ArrayList<ArrayList<Integer>> results) {
        if (index >= num.length) {
            ArrayList<Integer> set = new ArrayList<Integer>();
            for (int i = 0; i < pidx; i++)
                set.add(picked[i]);
            results.add(set);
            return;
        }
        int next = index + 1;
        while (next < num.length && num[next] == num[index])
            next++;
        subsetsWithDupHelper(num, next, picked, pidx, results);
        picked[pidx] = num[index];
        subsetsWithDupHelper(num, index + 1, picked, pidx + 1, results);
    }
}
