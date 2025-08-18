package bit_compute;

public class _4只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                // 获取每一个数的第i位
                sum += ((nums[j] >> i) & 1);
            }
            sum %= 3;
            // 把ret第i位修改为结果
            if (sum == 1) {
                ret = (1 << i) | ret;
            }
        }
        return ret;
    }
}
