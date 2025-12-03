public class _24等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        // 1.状态表示：dp[i] 表示以i结尾的全部子数组中为等差数组的个数
        // 2.状态转移方程：
        // 公差一样的情况nums[i] - nums[i-1] = nums[i - 1] - nums[i - 2]：dp[i] = dp[i - 1] + 1
        // 公差不一样的时候：dp[i] = 0
        // 3.初始化：dp[0] = 0, dp[1] = 0
        // 4.返回dp[n - 1]
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int ret = 0;
        for (int i = 2; i < n; i++) {
            int d1 = nums[i] - nums[i - 1];
            int d2 = nums[i - 1] - nums[i - 2];
            if (d1 == d2) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            ret += dp[i];
        }
        return ret;
    }
}
