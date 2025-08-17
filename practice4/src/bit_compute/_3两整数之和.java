package bit_compute;

public class _3两整数之和 {
    public int getSum(int a, int b) {
        // 按位异或两个数实现的是无进位相加
        // 按位与两个数实现的是计算各个位置是否需要进位
        while ((a & b) != 0) {
            int tmp1 = a ^ b;
            int tmp2 = (a & b) << 1;
            a = tmp1;
            b = tmp2;
        }
        return a ^ b;
    }
}
