public class Solution {
    public boolean isScramble(String s1, String s2) {
        return isScramble(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
    }

    private boolean isScramble(String s1, int s1s, int s1e, String s2, int s2s, int s2e) {
        if (s1s > s1e)
            return true;
        if (s1s == s1e)
            return s1.charAt(s1s) == s2.charAt(s2s);

        int[] map = new int[128];
        for (int i = s1s; i <= s1e; i++)
            map[s1.charAt(i)]++;
        for (int i = s2s; i <= s2e; i++) {
            char c = s2.charAt(i);
            map[c]--;
            if (map[c] < 0)
                return false;
        }
        
        for (int i = 0, ie = s1e - s1s; i < ie; i++) {
            if (isScramble(s1, s1s, s1s + i, s2, s2s, s2s + i) &&
                isScramble(s1, s1s + i + 1, s1e, s2, s2s + i + 1, s2e))
                return true;
            if (isScramble(s1, s1s, s1s + i, s2, s2e - i, s2e) &&
                isScramble(s1, s1s + i + 1, s1e, s2, s2s, s2e - i - 1))
                return true;
        }
        return false;
    }
}
