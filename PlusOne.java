public class Solution {
    public int[] plusOne(int[] digits) {
        int i;
        for (i = 0; i < digits.length; i++)
            if (digits[i] != 9)
                break;
        if (i == digits.length) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        int[] ret = new int[digits.length];
        int carry = 1;
        for (i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            ret[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0)
                break;
        }
        for (i -= 1; i >= 0; i--)
            ret[i] = digits[i];

        return ret;
    }
}
