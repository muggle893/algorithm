public class _20最大子数组的和 {
    public int maxSubArray(int[] nums) {
        // 状态表示dp[i]表示从0-i区间内，且以i位置为结尾的全部子数组中和最大的那一个
        // dp[0] = nums[0]
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        // 返回dp表中最大的那个值
        int n = nums.length;
        int[] dp = new int[n + 1];
        final int MIN_INT = -0x3f3f3f3f;
        dp[0] = MIN_INT;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
        }
        int ret = MIN_INT;
        for (int i = 1; i <= n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
