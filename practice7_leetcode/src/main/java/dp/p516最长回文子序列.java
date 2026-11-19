package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class p516最长回文子序列 {
    @Test
    public void longestPalindromeSubseq() {
        String s = "cbbd";
        // dp[i][j]表示i~j内最长回文子序列的长度
        // s[i] == s[j], dp[i][j] = dp[i + 1][j - 1] + 2
        // 还要和dp[i + 1][j]和dp[i][j - 1]比较
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        char[] cs = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            // 保存左下角的那个元素
            int leftPre = 0;
            for (int j = i + 1; j < n; j++) {
                int tmp = dp[j];
                dp[j] = Math.max(dp[j], dp[j - 1]);
                if (cs[i] == cs[j]) {
                    dp[j] = Math.max(leftPre + 2, dp[j]);
                }
                leftPre = tmp;
            }
        }
        System.out.println(dp[n - 1]);
    }
}
