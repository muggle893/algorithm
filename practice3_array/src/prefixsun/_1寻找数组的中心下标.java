package prefixsun;

public class _1寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        // 使用一个数组保存从0-i下标的和，用dp数组来保存
        // 下标为i的左边的和为dp[i - 1], 右边的和为dp[n - 1] - dp[i]
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            // 左边的和
            int leftSum = dp[i];
            // 右边的和
            int rightSum = dp[nums.length] - dp[i + 1];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
