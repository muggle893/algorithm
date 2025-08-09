package prefixsun;

public class _2除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        dpLeft[0] = nums[0];
        dpRight[n - 1] = nums[n - 1];
        for (int i = 1, j = n - 2; i < nums.length; i++, j--) {
            dpLeft[i] = nums[i] * dpLeft[i - 1];
            dpRight[j] = nums[j] * dpRight[j + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int lTotal = 1;
            int rTotal = 1;
            if (i - 1 >= 0) {
                lTotal = dpLeft[i - 1];
            }
            if (i + 1 < n) {
                rTotal = dpRight[i + 1];
            }
            res[i] = lTotal * rTotal;
        }
        return res;
    }
}
