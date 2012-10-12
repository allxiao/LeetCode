public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1len = s1.length(), s2len = s2.length(), s3len = s3.length();
        if (s1len + s2len != s3len)
            return false;
        boolean[][] dp = new boolean[s1len + 1][s2len + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1len; i++)
            dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        for (int j = 0; j < s2len; j++)
            dp[0][j+1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);

        for (int i = 1; i <= s1len; i++) {
            for (int j = 1; j <= s2len; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == c) ||
                    (dp[i][j-1] && s2.charAt(j-1) == c);
            }
        }

        return dp[s1len][s2len];
    }
}
