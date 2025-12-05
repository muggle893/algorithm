public class _29摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        // 1.状态表示：f[i]表示以i结尾的且nums[j] < nums[i]的最长摆动序列, 0 <=j <i
        //            g[i]表示以j结尾的且nums[j] > nums[i]的最长摆动序列
        // 2.状态转移方程
        // nums[j] < nums[i], f[i] = g[j] + 1, g[i] = 1
        // nums[j] > nums[i],  f[i] = 1, g[i] = f[j] + 1
        // 3.初始化f[0] = 0, g[0] = 0
        // 4.返回f和g数组中的最大值
        int n = nums.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        int res = 1;
        for (int i = 1; i <= n; i++) {
            int fMax = 1;
            int gMax = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j - 1] < nums[i - 1]) {
                    fMax = Math.max(g[j] + 1, fMax);
                } else if (nums[j - 1] > nums[i - 1]) {
                    gMax = Math.max(f[j] + 1, gMax);
                }
            }
            f[i] = fMax;
            g[i] = gMax;
            res = Math.max(res, Math.max(fMax, gMax));
        }
        return res;
    }
}
