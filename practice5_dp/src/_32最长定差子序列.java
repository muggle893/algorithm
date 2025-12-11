import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _32最长定差子序列 {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int d = -2;
        longestSubsequence(arr,d);
    }
    public static int longestSubsequence(int[] arr, int difference) {
        // 1.状态表示:dp[i]表示以arr[i]为结尾的最长定差子序列的长度
        // 2.dp[i] = dp[j] + 1, j < i, 且difference = arr[i] - arr[j]
        // 3.初始化：将dp数组里面的全部元素初始化为1
        // 4.返回dp[n - 1]

        // 下面的代码是优化后的最终版本, 因为计算dp[i]的时候只会去前面找以值为
        // (arr[i] - difference)结尾的最长定差子序列的最大的那一个
        // 比如：difference = 2, arr[i] = 7, 那么要找值为5结尾的最长定差子序列
        int n = arr.length;
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            int target = arr[i] - difference;
            map.put(arr[i], map.getOrDefault(target, 0) + 1);
            ret = Math.max(ret, map.get(arr[i]));
        }
        return ret;
    }
}
