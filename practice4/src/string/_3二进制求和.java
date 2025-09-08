package string;

public class _3二进制求和 {
    public String addBinary(String a, String b) {
        char[] res = new char[Math.max(a.length(), b.length()) + 1];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = Math.max(a.length(), b.length());
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res[k--] = (char)((sum % 2) + '0');
            carry = sum / 2;
        }
        //从索引k + 1开始拼接结果
        return String.valueOf(res,k + 1, res.length - 1 - k);
    }
}
