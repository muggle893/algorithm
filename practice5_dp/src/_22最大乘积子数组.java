public class _22最大乘积子数组 {
    public int maxProduct(int[] nums) {
        // 1.状态表示：f[i]表示以i结尾的子数组最大乘积和
        //           g[i]表示以i结尾的子数组最小乘积和
        // 2.状态转移方程：
        // f[i] = max(f[i - 1] * nums[i], g[i - 1] * nums[i], nums[i])
        // g[i] = min(f[i - 1] * nums[i], g[i - 1] * nums[i], nums[i])
        // 3.初始化
        // 创建n + 1的f和g数组，那么f[0] = g[0] = 1;转移方程的nums[i]要改为nums[i-1]
        // 4.填表，从左到右
        // 5.返回f[n]
        int n = nums.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        f[0] = 1;
        g[0] = 1;
        int fMax = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            f[i] = max(f[i - 1] * nums[i - 1], g[i - 1] * nums[i - 1], nums[i - 1]);
            g[i] = min(f[i - 1] * nums[i - 1], g[i - 1] * nums[i - 1], nums[i - 1]);
            fMax = Math.max(fMax, f[i]);
        }
        return fMax;
    }
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
