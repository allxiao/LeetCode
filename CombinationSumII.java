import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null)
            return results;
        Stack<Integer> picked = new Stack<Integer>();
        Arrays.sort(num);
        recHelper(num, target, 0, picked, results);
        return results;
    }

    private void recHelper(int[] num, int target,
                           int index,
                           Stack<Integer> picked,
                           ArrayList<ArrayList<Integer>> results) {
        if (target < 0)
            return;
        if (target == 0) {
            ArrayList<Integer> combination = new ArrayList<Integer>();
            for (Integer val : picked)
                combination.add(val);
            results.add(combination);
            return;
        }
        if (index >= num.length)
            return;
        picked.push(num[index]);
        recHelper(num, target - num[index], index + 1, picked, results);
        picked.pop();
        do {
            index++;
        } while (index < num.length && num[index] == num[index-1]);
        recHelper(num, target, index, picked, results);
    }
}
