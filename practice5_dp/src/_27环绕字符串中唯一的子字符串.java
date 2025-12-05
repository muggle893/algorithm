public class _27环绕字符串中唯一的子字符串 {
    public int findSubstringInWraproundString(String s) {
        // 1. dp[i]表示以i结尾的全部子字符串中出现的次数
        // 2. dp[i] = dp[i - 1] + 1 , 如果s[i]和s[i-1]相邻
        //    dp[i] = 1, 如果s[i]和s[i-1]不相邻
        // 3.初始化, 创建长度为n + 1的dp数组，dp[0] = 0, 对s进行处理s = " " + s
        // 4.返回dp[n]
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        s = " " + s;
        char[] str = s.toCharArray();
        int sum = 0;
        int[] ret = new int[26];
        for (int i = 1; i <= n; i++) {
            int v1 = str[i - 1] - 'a';
            int v2 = str[i] - 'a';
            if ((v1 + 1) % 26 == v2) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            ret[v2] = Math.max(dp[i], ret[v2]);
        }
        for (int i = 0; i < 26; i++) {
            sum += ret[i];
        }
        return sum;
    }
}
