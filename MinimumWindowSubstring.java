public class Solution {
    public String minWindow(String s, String t) {
        int tlen = t.length();
        if (tlen == 0)
            return "";
        int[] tmap = new int[128];
        for (int i = 0; i < tlen; i++)
            tmap[t.charAt(i)]++;
        int[] window = new int[128];

        int start = 0, end = 0;
        int count = 0;
        int maxstart = 0;
        int maxend = 0;
        while (end < s.length()) {
            boolean found = false;
            for (; end < s.length(); end++) {
                char c = s.charAt(end);
                if (tmap[c] > 0) {
                    window[c]++;
                    if (window[c] <= tmap[c])
                        count++;
                    if (count == tlen) {
                        found = true;
                        end++;
                        break;
                    }
                }
            }
            if (!found)
                break;
            for (; start < end; start++) {
                char c = s.charAt(start);
                if (tmap[c] > 0) {
                    window[c]--;
                    if (window[c] < tmap[c]) {
                        if (maxend == 0 || end - start < maxend - maxstart) {
                            maxstart = start;
                            maxend = end;
                        }
                        count--;
                        start++;
                        break;
                    }
                }
            }
        }
        if (maxend > 0) {
            return s.substring(maxstart, maxend);
        }
        else
            return "";
    }
}
