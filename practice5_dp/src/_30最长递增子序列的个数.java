public class _30最长递增子序列的个数 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5,4,7,2};
        int numberOfLIS = findNumberOfLIS(arr);

    }
    public static int findNumberOfLIS(int[] nums) {
        // 1.dp[i]表示以i为结尾的最长递增子序列长度
        // 2.dp[i] = dp[j] + 1;  其中j < i
        // 3.初始化, dp[0] = 0
        // 4.返回最长递增子序列的个数
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] cnt = new int[n + 1];
        dp[0] = 0;

        int seqMaxLen = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            int maxLenCnt = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i - 1] > nums[j - 1]) {
                    if (dp[i] < dp[j] + 1) {
                        maxLenCnt = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        maxLenCnt += cnt[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            cnt[i] = maxLenCnt;
            seqMaxLen = Math.max(seqMaxLen, dp[i]);
        }
        // 统计最长递增子序列的个数
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == seqMaxLen) {
                total += cnt[i];
            }
        }
        return total;
    }
}
