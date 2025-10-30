public class _2三步问题 {
    public int waysToStep(int n) {
        // 如果需要走到第i阶有三种走法
        // 1 从第i - 3一次走3阶
        // 2 从第i - 2一次走2阶
        // 3 从第i - 1一次走1阶
        if (n <= 2) {
            return n;
        }
        long a = 1;
        long b = 2;
        long c = 4;
        for (int i = 4; i <= n ; i++) {
            long tmp = (a + b + c) % (1000000007);
            a = b;
            b = c;
            c = tmp;
        }
        return (int)c;
    }
}
