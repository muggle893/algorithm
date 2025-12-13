import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _34最长等差数列 {
    public static void main(String[] args) {
        int[] arr = {0, 250, 500};
        int ret = longestArithSeqLength(arr);
        System.out.println(ret);
    }
    /**
     *  状态表示：dp[i]表示以i位置为结尾的最长等差数列长度
     *  但是我不知道i位置的前一个元素,不知道公差是几，所以这个状态表示有问题
     *  用dp[i][j]表示以j位置为结尾的且公差为nums[j] - nums[i]最长等差数列的长度
     *  其中i < j
     *  状态转移方程：
     *  假设k < i < j, 那么当nums[j] - nums[i] = nums[i] - nums[k]的时候
     *  dp[i][j] = dp[k][i] + 1
     *  否则dp[i][j] = 2
     *  原来的数组中同一个数可能出现多次那么，比如数字5在序列中出现了多次
     *  那当nums[k] = 5的时候，需要计算多次dp[hash[num[k]]][j]吗？
     *  可以优化吗？可以，因为在一个数组中一个数字出现在后面
     *  dp[hash[nums[k1]]][j]会大于或等于dp[hash[nums[k2]]][j]
     *  所以只需要取最近的那个数字的dp即可
     *  所以填表的时候还要搞一个哈希表记录一下以nums[k]为结尾等差子序列的的最大dp
     *  值
     *  填表顺序：从上到下，从左到右
     *  返回最长等差子序列
     * @param nums
     * @return
     */
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // 用来保存以值为nums[k]为结尾的最大的dp值对应的索引
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        int ret = 2;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = 2 * nums[i] - nums[j];
                if (hash.containsKey(a)) {
                    dp[i][j] = Math.max(dp[i][j],dp[hash.get(a)][i] + 1);
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            hash.put(nums[i], i);
        }
        return ret;
    }
}
