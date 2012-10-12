public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] map = new int[128];
        int start = 0;
        int maxlen = 1;
        for (int i = 0, slen = s.length(); i < slen; i++) {
            char c = s.charAt(i);
            if (map[c] > start)
                start = map[c];
            map[c] = i + 1;
            int len = i - start + 1;
            if (len > maxlen)
                maxlen = len;
        }

        return maxlen;
    }
}
