public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = min3(dp[i-1][j-1], dp[i-1][j]+1, dp[i][j-1]+1);
                else
                    dp[i][j] = min3(dp[i-1][j-1]+1, dp[i-1][j]+1, dp[i][j-1]+1);
            }
        }
        return dp[len1][len2];
    }

    public int min3(int i1, int i2, int i3) {
        if (i2 < i1)
            i1 = i2;
        if (i3 < i1)
            i1 = i3;
        return i1;
    }
}
