import java.util.HashMap;
import java.util.Map;

public class _33最长斐波那契子序列的长度 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        lenLongestFibSubseq(arr);
    }
    public static int lenLongestFibSubseq(int[] arr) {
        // 1.状态表示dp[i][j]表示以arr[i]和arr[j]结尾的最长斐波那契子序列的长度
        // 其中，i < j
        // 2.状态转移方程：arr[j] - arr[i] = arr[k]
        // 当arr[k]的值小于arr[j]且，在数组中存在时, dp[i][j] = dp[k][i] + 1
        // 当arr[k]>=arr[i]且arr[k]<=arr[j], dp[i][j]不存在
        // 当arr[k]再数组中找不到时，那么dp[i][j]不存在
        // 3.初始化：dp数组全都初始化为2， 刚开始用哈希表记录每一个元素对应的下标
        // 4.填表顺序，从下到上，从左到右,
        // 5.返回数组中最大的那个元素
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> hash = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            hash.put(arr[i], i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int index = hash.getOrDefault(arr[j] - arr[i], -1);
                if (index >= 0 && index < i) {
                    dp[i][j] = dp[index][i] + 1;
                } else {
                    dp[i][j] = 2;
                }
                if (dp[i][j] > 2) {
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret;
    }
}
