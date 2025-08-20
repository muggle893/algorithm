package mock;

public class _4外观数列 {
    public String countAndSay(int n) {
        // 循环n - 1次，每次都用前面的字符串计算当前的行程长度编码
        String res = "1";
        for (int i = 0; i < n - 1; i++) {
            res = compress(res);
        }
        return res;
    }
    public String compress(String s) {
        int i = 0, j = 1;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            sb = sb.append((char)(j - i + '0'));
            sb = sb.append(s.charAt(i));
            // 更新i
            i = j;
        }
        return sb.toString();
    }
}
