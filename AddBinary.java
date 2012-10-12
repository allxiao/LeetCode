public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;

        int len = (a.length() > b.length() ? a.length() : b.length()) + 1;
        char[] cr = new char[len];
        int ia = a.length() - 1, ib = b.length() - 1, ir = cr.length - 1;
        int carry = 0;
        while (ia >= 0 || ib >= 0) {
            int result = carry;
            if (ia >= 0)
                result += (a.charAt(ia) - '0');
            if (ib >= 0)
                result += (b.charAt(ib) - '0');
            carry = result / 2;
            cr[ir--] = (result % 2 == 0) ? '0' : '1';
            ia--;
            ib--;
        }
        if (carry > 0)
            cr[ir--] = '1';

        return new String(cr, ir+1, cr.length - ir - 1);
    }
}
