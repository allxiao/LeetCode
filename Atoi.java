public class Solution {
    // this solution can pass all the test cases
    // but it is not good enough, for a better implementation,
    // refer to http://arieshout.me/2012/03/implementation-of-atoi.html
    public int atoi(String str) {
        long result = 0;
        int sign = 1;
        int i = 0;
        int len = str.length();
        int intmax = Integer.MAX_VALUE;
        long intmin = -(long)Integer.MIN_VALUE;
        while (i < len && str.charAt(i) == ' ')
            i++;
        if (i == len)
            return 0;
        if (str.charAt(i) == '+')
            i++;
        else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        char c;
        while (i < len) {
            c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
                if (sign > 0 && result > intmax)
                    return Integer.MAX_VALUE;
                else if (sign < 0 && result > intmin)
                    return Integer.MIN_VALUE;
                i++;
            }
            else {
                break;
            }
        }
        return sign > 0 ? (int)result : (int)-result;
    }
}
