public class Solution {
    public boolean isMatch(String s, String p) {
        //return matchHelper(s, p);
        return matchHelper(s, 0, s.length() - 1, p, 0, p.length() - 1);
    }

    public boolean matchHelper(String s, String p) {
        int slen = s.length(), plen = p.length();
        int si = 0, pi = 0;
        int ps, pp;
        boolean star = false;
        LOOP_START:
        for (ps = si, pp = pi; ps < slen; ) {
            if (pp >= plen) {
                if (!star)
                    return false;
                si++;
                ps = si;
                pp = pi;
                continue LOOP_START;
            }
            char pchar = p.charAt(pp);
            switch (pchar) {
            case '?':
                break;
            case '*':
                star = true;
                si = ps;
                pi = pp + 1;
                if (pi >= plen) return true;
                pp = pi;
                continue LOOP_START;
            default:
                if (s.charAt(ps) != pchar) {
                    if (!star)
                        return false;
                    si++;
                    ps = si;
                    pp = pi;
                    continue LOOP_START;
                }
                break;
            }
            ps++;
            pp++;
        }
        while (pp < plen && p.charAt(pp) == '*')
            pp++;
        return pp >= plen;
    }

    private boolean matchHelper(String s, int sstart, int send, String p, int pstart, int pend) {
        if (pstart > pend) {
            return sstart > send;
        }
        if (sstart > send) {
            for (int i = pstart; i <= pend; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        char cpend = p.charAt(pend);
        if (cpend != '*') {
            if (cpend == '?') {
                return matchHelper(s, sstart, send - 1, p, pstart, pend - 1);
            }
            else {
                if (s.charAt(send) == cpend)
                    return matchHelper(s, sstart, send - 1, p, pstart, pend - 1);
                return false;
            }
        }
        else {
            char cpstart = p.charAt(pstart);
            if (cpstart == '?')
                return matchHelper(s, sstart + 1, send, p, pstart + 1, pend);
            else if (cpstart == '*') {
                while (pstart < pend - 1 && p.charAt(pstart + 1) == '*')
                    pstart++;
                for (int i = send + 1; i >= sstart; i--) {
                    if (matchHelper(s, i, send, p, pstart + 1, pend))
                        return true;
                }
                return false;
            }
            else {
                if (s.charAt(sstart) == cpstart)
                    return matchHelper(s, sstart + 1, send, p, pstart + 1, pend);
                return false;
            }
        }
    }
}
