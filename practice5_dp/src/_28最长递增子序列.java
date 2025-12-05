public class _28最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        // 1.dp[i]表示以i结尾的最长严格递增子序列
        // 2.dp[i] = max(dp[j] + 1), j 从0到i - 1, 如果nums[i] > nums[j]
        // 3.初始化dp[0] = 0, dp数组的长度为n + 1
        // 4.从左向右填表
        // 5.返回dp[n - 1]
        int n = nums.length;
        int[] dp =  new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxVal = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (j + 1 <= maxVal) {
                    break;
                }
                if (nums[i - 1] > nums[j - 1]) {
                    maxVal = Math.max(maxVal, dp[j] + 1);
                }
            }
            dp[i] = maxVal;
        }
        int res = 1;
        for (int val : dp) {
            res = Math.max(val, res);
        }
        return res;
    }
}
