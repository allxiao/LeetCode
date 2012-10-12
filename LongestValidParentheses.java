public class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        int k = 0, l = 0;
        int slen = s.length();
        for (int i = 0; i < slen; i++)  {
            if (s.charAt(i) == '(') {
                k++;
                l++;
            }
            else {
                k--;
                l++;
            }
            if (k == 0 && l > maxlen)
                maxlen = l;
            else if (k < 0)
                k = l = 0;
        }

        k = l = 0;
        for (int i = slen - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                k++;
                l++;
            }
            else {
                k--;
                l++;
            }
            if (k == 0 && l > maxlen)
                maxlen = l;
            else if (k < 0)
                k = l = 0;
        }

        return maxlen;
    }
}
