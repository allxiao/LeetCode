import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        permuteHelper(num, 0, results);
        return results;
    }

    private void permuteHelper(int[] num, int index, ArrayList<ArrayList<Integer>> results) {
        if (index >= num.length - 1) {
            ArrayList<Integer> result = new ArrayList<Integer>(num.length - 1);
            for (int i : num)
                result.add(i);
            results.add(result);
            return;
        }
        permuteHelper(num, index + 1, results);
        OUTER:
        for (int i = index + 1; i < num.length; i++) {
            for (int j = index; j < i; j++) {
                if (num[j] == num[i])
                    continue OUTER;
            }
            swap(num, i, index);
            permuteHelper(num, index + 1, results);
            swap(num, i, index);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
