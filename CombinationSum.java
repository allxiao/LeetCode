import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> picked = new Stack<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, picked, results);
        return results;
    }

    private void helper(int[] candidates,
                        int target,
                        int idx,
                        Stack<Integer> picked,
                        ArrayList<ArrayList<Integer>> results) {
        if (target < 0)
            return;
        if (target == 0) {
            ArrayList<Integer> combination = new ArrayList<Integer>();
            for (Integer integer : picked)
                combination.add(integer);
            results.add(combination);
            return;
        }
        if (idx >= candidates.length)
            return;
        picked.push(candidates[idx]);
        helper(candidates, target - candidates[idx], idx, picked, results);
        picked.pop();
        do {
            idx++;
        } while (idx < candidates.length && candidates[idx] == candidates[idx-1]);
        if (idx < candidates.length)
            helper(candidates, target, idx, picked, results);
    }
}
