package dp;

import java.util.List;

public class p139单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        java.util.List<String> wordDict = new java.util.ArrayList<>(java.util.Arrays.asList("leet", "code"));
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 思路1：遍历wordDict中，从s中查找wordDict[i]，如果找到了单词就把单词从s中删除掉
        // 最后s变为""就说明可以拆分
        // 思路2：dp[i][j]表示i~j区间中的字符串能不能用字典里的字符串拼出来
        // 怎么得到dp[i][j]呢，分成两部分
        // p1~p2, p2+1 ~p3，其中p1指向区间的最左边p3指向区间的最右边
        // 如果前半部分能在字典中找到那就看后半部分能不能用字典中的字符串拼接出来
        // 这样就能得到dp[i][j]
        // 所以dp[i][j]的值依赖当前行的后面行和当前行的前面元素
        // 这样是可以推导出dp[0][n - 1]的
        // 时间复杂度为o(n^3)
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    if (dp[i][j] == true) {
                        break;
                    }
                    // 0~k分为左边的部分, k+1~j分为右边的部分
                    if (k == j) {
                        if (wordDict.contains(s.substring(i, j + 1))) {
                            dp[i][j] = true;
                        }
                    } else {
                        dp[i][j] = dp[i][k] && dp[k + 1][j];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

}
