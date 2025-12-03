import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _26单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 1.状态表示：dp[i]表示从0-i的字符串能否用单词字典中的单词拼接出来，true表示可以，false表示不行
        // 2.dp[i] = (dp[j-1] == true && contains(s.substring(j, i)) ? : true : false);
        // 3.初始化：dp[0] = true;
        // 4.填表顺序：从左到右
        // 5.返回dp[n-1]
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        s = " " + s;
        Set<String> dic = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (dp[j - 1] && dic.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
