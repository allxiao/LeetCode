public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int si, String p, int pi) {
        int slen = s.length();
        int plen = p.length();
        if (pi >= plen)
            return si >= slen;
        if (si >= slen) {
            if ((plen - pi) % 2 != 0)
                return false;
            for (int i = pi + 1; i < plen; i += 2)
                if (p.charAt(i) != '*' || p.charAt(i - 1) == '*')
                    return false;
            return true;
        }
        char pchar = p.charAt(pi);
        if (pchar == '*')
            return false;
        if (pi < plen - 1 && p.charAt(pi + 1) == '*') {
            if (pchar == '.') {
                for (int i = slen; i >= si; --i) {
                    if (isMatch(s, i, p, pi + 2))
                        return true;
                }
            }
            else {
                int count = 0;
                for (int i = si; i < slen; i++) {
                    if (s.charAt(i) != pchar)
                        break;
                    count++;
                }
                for (int i = si + count; i >= si; i--) {
                    if (isMatch(s, i, p, pi + 2))
                        return true;
                }
            }
        }
        else if (pchar == '.' || s.charAt(si) == pchar) {
            return isMatch(s, si + 1, p, pi + 1);
        }
        return false;
    }
}
