import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> grayCodeFast(int n) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int bound = 1 << n;
        for (int i = 0; i < bound; i++) {
            results.add( (i >> 1) ^ i );
        }
        return results;
    }

    public ArrayList<Integer> grayCode2(int n) {
        int[] code = new int[1];
        ArrayList<Integer> results = new ArrayList<Integer>();
        helper2(n, code, results);
        return results;
    }

    private void helper2(int n, int[] code, ArrayList<Integer> results) {
        if (n == 0) {
            results.add(code);
            return;
        }
        helper2(n - 1, code, results);
        int mask = 1 << (n - 1);
        code[0] ^= mask;
        helper2(n - 1, code, results);
    }

    // treat the inverse positions as inorder traversal
    // elements of a binary tree of the form:
    //         n
    //        / \
    //      n-1 n-1
    //     / \   /  \
    //   n-2 n-2 n-2 n-2
    // ......
    public ArrayList<Integer> grayCode(int n) {
        int code = 0;
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(code);

        Stack<Integer> positions = new Stack<Integer>();
        while (!positions.isEmpty() || n > 0) {
            if (n > 0) {
                positions.push(n);
                n--;
            }
            else {
                n = positions.pop();
                code = inverse(code, n);
                results.add(code);
                n--;
            }
        }

        return results;
    }

    private int inverse(int code, int pos) {
        int mask = 1 << (pos - 1);
        code ^= mask;
        return code;
    }
}
