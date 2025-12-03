public class _23乘积为正数的最长子数组长度 {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,0,1};
        int res = getMaxLen(arr);
        System.out.println(res);
    }
    public static int getMaxLen(int[] nums) {
        // 1.状态表示：f[i]表示以i结尾且乘积为正数的最长子数组的长度
        //           g[i]表示以i结尾且乘积为负数的最长子数组的长度
        // 2.状态转移方程：
        // nums[i] > 0 , f[i] = f[i-1] + 1, g[i] = g[i-1] + 1, 这里g[i] 还要考虑g[i-1]的有效性
        // nums[i] < 0,  f[i] = g[i-1] + 1, g[i] = f[i-1] + 1， 这里f[i]要考虑g[i-1]的有效性
        // nums[i] = 0,  f[i] = 0, g[i] = 0
        // 3.初始化：创建长度为n + 1的f和g数组，f[0] = 0, g[0] = 0。
        // 4.填表顺序：从左到右
        // 5.返回f[n]
        int n = nums.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        f[0] = 0;
        g[0] = 0;
        int fMax = f[0];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] > 0) {
                f[i] = f[i - 1] + 1;
                if (g[i - 1] == 0) {
                    g[i] = 0;
                } else {
                    g[i] = g[i - 1] + 1;
                }
            } else if (nums[i - 1] < 0) {
                g[i] = f[i - 1] + 1;
                if (g[i - 1] == 0) {
                    f[i] = 0;
                } else {
                    f[i] = g[i - 1] + 1;
                }
            } else if (nums[i - 1] == 0){
                f[i] = 0;
                g[i] = 0;
            }
            fMax = Math.max(f[i], fMax);
        }
        return fMax;
    }
}
