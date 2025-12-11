import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class _31最长数对链 {
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8},{4,5}};
        findLongestChain(pairs);
    }
    public static int findLongestChain(int[][] pairs) {
        // 1.根据数对的第一个数进行排序
        // 2.状态表示：dp[i]表示以i数对结尾的数对的最长数对链的长度
        // 3.状态转移方程：d[i] = max(dp[j] + 1), 数对j的第二个数必须小于数对i的第一个数
        // 4.初始化：将dp数组全都初始化为1
        // 5.返回dp[n-1]

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (pair1, pair2)->{
            return pair1[0] - pair2[0];
        });
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
