package dp;

public class p72编辑距离 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        minDistance(word1, word2);
    }
    public static  int minDistance(String word1, String word2) {

        // 状态定义：dp[i][j]表示把word1的前i个字符变为word2的前j个字符的最小操作次数
        // 状态转移：
        // word1[i] == word2[j], dp[i][j] = dp[i - 1][j - 1]
        // word1[i] != word2[j],
        // 插入字符word2[j], 看dp[i][j - 1]
        // 删除字符word1[i], 看dp[i - 1][j]
        // 替换字符word1[i], 看dp[i - 1][j - 1]
        // 取Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
        // 初始化dp[0][j] = j(把word1变为word2的前j个字符只能是一直插入字符，才是最小操作次数)
        // dp[i][0] = i(把word1的前i个字符变为空串只能是一直删除字符，才是最小操作次数)
        // 遍历顺序：从上到下，从左到右
        // 返回dp[n][m]
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i - 1] == w2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }

    // 空间优化版本
    public  int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] dp = new int[m + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for (int j = 1; j <= m; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= n; i++) {
            // 初始化每一行的左上角元素
            int store = i - 1;
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[j] = i;
                    continue;
                }
                int tmp = dp[j];
                if (w1[i - 1] == w2[j - 1]){
                    dp[j] = store;
                } else {
                    dp[j] = Math.min(store, Math.min(dp[j], dp[j - 1])) + 1;
                }
                store = tmp;
            }
        }
        return dp[m];
    }
}
