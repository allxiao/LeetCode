public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int[] memo = new int[s.length()];
        return numDecodings(s, 0, memo);
    }

    public int numDecodingsDP(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            char i_2 = s.charAt(i - 2);
            char i_1 = s.charAt(i - 1);
            if (i_2 == '1') {
                if (i_1 == '0') dp[i] = dp[i-2];
                else dp[i] = dp[i-1] + dp[i-2];
            }
            else if (i_2 == '2') {
                if (i_1 == '0') dp[i] = dp[i-2];
                else if (i_1 > '6') dp[i] = dp[i-1];
                else dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                if (i_1 == '0') return 0;
                else dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }

    private int numDecodings(String s, int start, int[] memo) {
        int len = s.length();
        if (start >= len)
            return 1;
        if (memo[start] > 0)
            return memo[start];
        char first = s.charAt(start);
        if (first == '0')
            return 0;
        if (start == len - 1)
            return 1;
        int ret = 0;
        char second = s.charAt(start + 1);
        if (first == '1') {
            if (second == '0')
                ret = numDecodings(s, start + 2, memo);
            else
                ret = numDecodings(s, start + 1, memo) + numDecodings(s, start + 2, memo);
        }
        else if (first == '2') {
            if (second == '0')
                ret = numDecodings(s, start + 2, memo);
            else if (second <= '6')
                ret = numDecodings(s, start + 1, memo) + numDecodings(s, start + 2, memo);
            else
                ret = numDecodings(s, start + 2, memo);
        }
        else
            ret = numDecodings(s, start + 1, memo);
        memo[start] = ret;
        return ret;
    }
}
