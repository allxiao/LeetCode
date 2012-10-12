import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int[] stack = new int[k];
        helper(n, 1, stack, 0, results);
        return results;
    }

    private void helper(int n, int current, int[] stack, int stackpos, ArrayList<ArrayList<Integer>> results) {
        if (stackpos == stack.length) {
            ArrayList<Integer> c = new ArrayList<Integer>();
            for (int val : stack)
                c.add(val);
            results.add(c);
            return;
        }
        if (current > n)
            return;
        helper(n, current + 1, stack, stackpos, results);
        stack[stackpos] = current;
        helper(n, current + 1, stack, stackpos+1, results);
    }
}
