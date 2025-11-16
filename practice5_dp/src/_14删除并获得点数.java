import java.util.Arrays;

public class _14删除并获得点数 {
    public int findMaxElem(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = -1;
        for (int k : nums) {
            if (max < k) max = k;
        }
        return max;
    }
    public int deleteAndEarn(int[] nums) {
        int maxNum = findMaxElem(nums);
        int[] arr = new int [maxNum + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 1; i < maxNum + 1; i++) {
            arr[i] = i * arr[i];
        }
        int res = rob(Arrays.copyOfRange(arr, 1, maxNum + 1));
        return res;
    }
    public int rob(int[] nums) {
        // 1.状态表示：f[i] 表示从0-i，并且偷取第i个房屋的钱财的最大偷取金额
        //           g[i] 表示从0-i并且不偷取第i个房屋的钱财的最大偷取金额
        // 2.状态转移方程：f[i] = nums[i] + f[i - 1]
        //              g[i] = max(g[i-1], f[i-1])
        // 3.初始化：f[0] = nums[0], g[0] = 0
        // 4.填表顺序：从左到右
        // 5.返回max(f[n-1], g[n-1])
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + nums[i];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }
        return Math.max(f[n - 1], g[n - 1]);
    }
}
