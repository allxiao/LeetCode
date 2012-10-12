import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3)
            return results;
        Arrays.sort(num);
        for (int i = 0, iend = num.length - 2; i < iend; ) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    ArrayList<Integer> found = new ArrayList<Integer>(3);
                    found.add(num[i]);
                    found.add(num[j]);
                    found.add(num[k]);
                    results.add(found);
                    do {
                        j++;
                    } while (j < k && num[j] == num[j-1]);
                    do {
                        k--;
                    } while (j < k && num[k] == num[k+1]);
                }
                else if (sum < 0) {
                    do {
                        j++;
                    } while (j < k && num[j] == num[j-1]);
                }
                else {
                    do {
                        k--;
                    } while (j < k && num[k] == num[k+1]);
                }
            }
            do {
                i++;
            } while (i < iend && num[i] == num[i-1]);
        }
        return results;
    }
}
