public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return haystack;
        if (needle.length() == 1) {
            int index = haystack.indexOf(needle.charAt(0));
            if (index >= 0)
                return haystack.substring(index, haystack.length());
            else
                return null;
        }
        int[] t = computeFallbackTable(needle);
        int m = 0, i = 0;
        while (m + i < haystack.length()) {
            if (haystack.charAt(m + i) == needle.charAt(i)) {
                if (i == needle.length() - 1)
                    return haystack.substring(m, haystack.length());
                else
                    i++;
            }
            else {
                m = m + i - t[i];
                if (t[i] > 0)
                    i = t[i];
                else
                    i = 0;
            }
        }
        return null;
    }

    private int[] computeFallbackTable(String needle) {
        int[] t = new int[needle.length()];
        t[0] = -1;
        t[1] = 0;
        int pos = 2;
        int cnd = 0;
        while (pos < t.length) {
            if (needle.charAt(pos - 1) == needle.charAt(cnd))
                t[pos++] = ++cnd;
            else if (cnd > 0)
                cnd = t[cnd];
            else
                t[pos++] = 0;
        }
        return t;
    }
}
