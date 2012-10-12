public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        // can be optimized to use O(K) space and O(NK) time
        // where K is the length of the shorted string
        char[] prefix = strs[0].toCharArray();
        int len = prefix.length;
        for (int i = 1; i < strs.length; i++) {
            int ith_length = strs[i].length();
            if (ith_length < len)
                len = ith_length;
            for (int j = 0; j < len; j++) {
                if (strs[i].charAt(j) != prefix[j]) {
                    len = j;
                    break;
                }
            }
        }
        return new String(prefix, 0, len);
    }
}
