public class _4解码方法 {
    public int numDecodings(String s) {
       int n = s.length();
       char[] t = s.toCharArray();
       int[] dp = new int[n + 1];
       dp[0] = 1;
       dp[1] = s.charAt(0) == '0' ? 0 : 1;
       for (int i = 2; i <= n; i++) {
           if (t[i - 1] != '0') {
               dp[i] += dp[i - 1];
           }
           int tmp = ((t[i - 2] - '0') * 10 + (t[i-1] - '0'));
           if (tmp >= 10 && tmp <= 26) {
               dp[i] += dp[i - 2];
           }
       }
       return dp[n];
    }
}
