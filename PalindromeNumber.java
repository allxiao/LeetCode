public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int base = 1, num = x / 10;
        while (num != 0) {
            base *= 10;
            num /= 10;
        }
        int lbase = 1;
        while (lbase < base) {
            if ((x / base) % 10 != (x / lbase) % 10)
                return false;
            lbase *= 10;
            base /= 10;
        }
        return true;
    }
}
