public class Solution {
    public boolean isNumber(String s) {
        int[] index = new int[1];
        spaces(s, index);
        boolean floatFound = parseFloat(s, index);
        spaces(s, index);
        return floatFound && index[0] >= s.length();
    }
    
    private boolean parseFloat(String s, int[] index) {
        sign(s, index);
        boolean integerPart = digits(s, index);
        boolean periodFound = period(s, index);
        boolean fraction = digits(s, index);
        if (!integerPart && !fraction)
            return false;
        boolean expFound = exp(s, index);
        if (expFound) {
            sign(s, index);
            return digits(s, index);
        }
        return true;
    }

    private boolean parseChars(String s, int[] index, char[] cmatch, boolean repeat) {
        int i = index[0];
        int slen = s.length();
        boolean found = false;
        OUTER:
        while (i < slen) {
            char c = s.charAt(i);
            for (char cm : cmatch) {
                if (cm == c) {
                    found = true;
                    i++;
                    if (!repeat)
                        break OUTER;
                    continue OUTER;
                }
            }
            break;
        }
        index[0] = i;
        return found;
    }

    private boolean spaces(String s, int[] index) {
        return parseChars(s, index, new char[]{' '}, true);
    }

    private boolean sign(String s, int[] index) {
        return parseChars(s, index, new char[]{'+', '-'}, false);
    }

    private boolean digits(String s, int[] index) {
        return parseChars(s, index, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, true);
    }

    private boolean period(String s, int[] index) {
        return parseChars(s, index, new char[] { '.' }, false);
    }

    private boolean exp(String s, int[] index) {
        return parseChars(s, index, new char[] { 'e', 'E'}, false);
    }
}
