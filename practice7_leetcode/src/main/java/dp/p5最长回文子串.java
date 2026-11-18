package dp;

import java.util.Arrays;

public class p5最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
//    public static String longestPalindrome(String s) {
//        // 状态定义：dp[i][j] 表示i~j区间内的最长回文子串
//        // 1.s[i] == s[j]，如果dp[i + 1][j - 1] == (j - 1 - i - 1 + 1) , dp[i][j] = dp[i +1][j - 1] + 2
//        // 否则dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
//        // 2.s[i] != s[j], dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
//        // 初始化：i == j, dp[i][j] = 1, i > j, d[i][j] = 0
//        // 滚动数组优化：只用一行dp数组来存储
//        // 优化后的dp数组不用初始化，只要在遍历逻辑中加上i == j , dp[i][j] == 1就可以了
//        int n = s.length();
//        int[] dp = new int[n];
//        char[] cs = s.toCharArray();
//        int tmp = 0; // 保存左下角的那个值
//        int maxLen = 0; // 记录最长回文子串长度
//        int row = -1; // 记录最长回文子串的行下标
//        int col = -1; // 记录最长回文子串的列下标
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                int t = dp[j];
//                if (i == j) {
//                    dp[j] = 1;
//                } else if (cs[i] == cs[j] && tmp == (j - i - 1)) {
//                    dp[j] = tmp + 2;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j - 1]);
//                }
//                if (dp[j] > maxLen) {
//                    maxLen = dp[j];
//                    row = i;
//                    col = j;
//                }
//                tmp = t; // 更新左下角的那个值
//            }
//        }
//        return s.substring(row, col + 1);
//    }

    public static String longestPalindrome(String s) {
        // 用dp[i][j]表示i~j的字符串是不是一个回文串
        // s[i] == s[j], dp[i][j] = dp[i + 1][j - 1]
        // s[i] != s[j] , dp[i][j] = false
        // 优化为滚动数组, dp数组初始化为true
        int n = s.length();
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        char[] cs = s.toCharArray();
        boolean tmp = true; // 保留左下角的元素
        int maxLen = 1;
        int row = 0;
        int col = 0;
        for (int i = n - 1; i >= 0; i--) {
            tmp = true;
            for (int j = i + 1; j < n; j++) {
                boolean t = dp[j];
                if (cs[i] == cs[j]) {
                    dp[j] = tmp;
                } else {
                    dp[j] = false;
                }
                if (dp[j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    row = i;
                    col = j;
                }
                tmp = t;
            }
        }
        return s.substring(row, col + 1);
    }


}
