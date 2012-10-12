public class Solution {
    public String longestPalindrome(String s) {
        int maxstart = 0;
        int maxlen = 0;
        int slen = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                int start = i - j;
                int end = i + 1;
                while (start >= 0 && end < slen && s.charAt(start) == s.charAt(end)) {
                    start--;
                    end++;
                }
                int len = end - start - 1;
                if (len > maxlen) {
                    maxlen = len;
                    maxstart = start + 1;
                }
            }
        }
        return s.substring(maxstart, maxstart + maxlen);
    }
}
