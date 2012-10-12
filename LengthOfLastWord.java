public class Solution {
    public int lengthOfLastWord(String s) {
        int i, j;
        if (s == null)
            return 0;
        for (i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != ' ')
                break;
        for (j = i - 1; j >= 0; j--)
            if (s.charAt(j) == ' ')
                break;
        if (i < 0)
            return 0;
        return i - j;
    }
}
