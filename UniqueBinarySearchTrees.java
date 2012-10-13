public class Solution {
    /**
       let f(n) = numTrees(n)

       to calculate f(n), we choose a value in [1..n] to be the root
       then the left subtree has [0..n-1] nodes respectively
       and the right subtree has [n-1..0] nodes

       thus f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0)

       specially, we choose f(0) = 1
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
