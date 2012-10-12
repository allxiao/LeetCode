public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long long_dividend = dividend;
        if (long_dividend < 0) {
            long_dividend = -long_dividend;
            sign = -sign;
        }
        long long_divisor = divisor;
        if (long_divisor < 0) {
            long_divisor = -long_divisor;
            sign = -sign;
        }
        long result = divide(long_dividend, long_divisor);
        return sign > 0 ? (int)result : (int)-result;
    }

    private long divide(long dividend, long divisor) {
        long ret = 0;
        while (dividend >= divisor) {
            long tmp = divisor;
            long shift = 0;
            while ( (tmp << 1) <= dividend ) {
                tmp <<= 1;
                shift++;
            }
            dividend -= tmp;
            ret |= (1 << shift);
        }
        return ret;    
    }
}
