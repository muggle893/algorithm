public class _25最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        // 1.定义状态：f[i] 表示以i位置为结尾的的最长湍流子数组的长度, 且nums[i - 1] < nums[i];
        //          g[i] 表示以i位置为结尾的的最长湍流子数组的长度, 且nums[i - 1] > nums[i];
        // 2.状态转移方程：
        // nums[i - 1] < nums[i], f[i] = g[i-1] + 1, g[i] = 0
        // nums[i - 1] > nums[i], g[i] = f[i-1] + 1, f[i] = 0
        // 3.初始化
        // f[0] = 0, g[0] = 0
        // 4.返回max(fMax, gMax)
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = 1;
        g[0] = 1;
        int fMax = 1;
        int gMax = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                f[i] = g[i - 1] + 1;
                g[i] = 1;
            }else if (arr[i - 1] > arr[i]) {
                g[i] = f[i - 1] + 1;
                f[i] = 1;
            } else {
                f[i] = 1;
                g[i] = 1;
            }
            fMax = Math.max(fMax, f[i]);
            gMax = Math.max(gMax, g[i]);

        }
        return Math.max(fMax, gMax);
    }
}
