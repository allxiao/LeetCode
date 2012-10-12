import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        if (n == 0)
            return results;
        char[] stack = new char[n*2];
        int spos = 0;
        helper(n, 0, 0, stack, 0, results);
        return results;
    }

    private void helper(int n, int lcount, int lremain, char[] stack, int sp, ArrayList<String> results) {
        if (lcount == n) {
            for (int i = sp; i < stack.length; i++) {
                stack[i] = ')';
            }
            results.add(new String(stack));
            return;
        }
        stack[sp] = '(';
        helper(n, lcount + 1, lremain + 1, stack, sp + 1, results);
        if (lremain > 0) {
            stack[sp] = ')';
            helper(n, lcount, lremain - 1, stack, sp + 1, results);
        }
    }
}
