import java.util.ArrayList;

public class Solution {
    static final char[][] letterTable = {
        {' '},
        {'1'},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if (digits == null)
            return results;
        char[] picked = new char[digits.length()];
        letterCombinations(digits, 0, picked, results);
        return results;
    }

    private void letterCombinations(String digits, int index, char[] picked, ArrayList<String> results) {
        if (index >= digits.length()) {
            results.add(new String(picked));
            return;
        }
        int c = digits.charAt(index) - '0';
        for (int i = 0; i < letterTable[c].length; i++) {
            picked[index] = letterTable[c][i];
            letterCombinations(digits, index + 1, picked, results);
        }
    }
}
