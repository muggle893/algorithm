public class _20最大子数组的和 {
    public int maxSubArray(int[] nums) {
        // 状态表示dp[i]表示从0-i区间内，且以i位置为结尾的最大子数组的和
        // dp[0] = nums[0]
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        // 返回dp表中最大的那个值
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
