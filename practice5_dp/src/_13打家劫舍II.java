import java.util.Arrays;

public class _13打家劫舍II {
    public int rob(int[] nums) {
        // 分为两种情况：第一个位置不偷和第一个位置偷
        // 偷下标为0的房屋时，偷取的最大金额为nums[0] + rob2(2~n-1, nums)
        // 不偷下标为0的房屋时，偷取的最大金额为rob2(1~n-1, nums)
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int v1 = nums[0] + rob2(Arrays.copyOfRange(nums, 2, nums.length - 1));
        int v2 = rob2(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(v1, v2);
    }
    public int rob2(int[] nums) {
        // 1.状态表示：f[i] 表示从0-i，并且偷取第i个房屋的钱财的最大偷取金额
        //           g[i] 表示从0-i并且不偷取第i个房屋的钱财的最大偷取金额
        // 2.状态转移方程：f[i] = nums[i] + f[i - 1]
        //              g[i] = max(g[i-1], f[i-1])
        // 3.初始化：f[0] = nums[0], g[0] = 0
        // 4.填表顺序：从左到右
        // 5.返回max(f[n-1], g[n-1])
        int n = nums.length;
        if (n == 0) return 0;
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
