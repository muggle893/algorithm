package bit_compute;

public class _1判定字符是否唯一 {
    public boolean isUnique(String astr) {
        // 可以使用0中的各个比特位，来记录各个字符是否已经被使用过
        // 位置0上的比特来表示a, 位置1上的比特来表示b, 以此类推
        // 遇到字符就先计算位置pos，然后先检查位置pos上的比特是否为0
        // 遇到重复的字符直接返回false，否则将pos位置标志为1
        // 获取i位置的比特位(n >> pos) & 1
        // 设置i位置的比特位为1, (1 << pos) | n
        int n = 0;
        for (int i = 0; i < astr.length(); i++) {
            int pos = astr.charAt(i) - 'a';
            int bit = (n >> pos) & 1;
            if (bit == 1) {
                return false;
            } else {
                n = (1 << pos) | n;
            }
        }
        return true;
    }
}
