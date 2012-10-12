import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4)
            return results;
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0, iend = num.length - 3; i < iend; i++) {
            for (int j = i + 1, jend = num.length - 2; j < jend; j++) {
                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum == target) {
                        ArrayList<Integer> found = new ArrayList<Integer>();
                        found.add(num[i]);
                        found.add(num[j]);
                        found.add(num[k]);
                        found.add(num[l]);
                        if (set.add(found)) {
                            results.add(found);
                        }
                        k++;
                        l--;
                    }
                    else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return results;
    }
}
