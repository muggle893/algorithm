package string;

import org.omg.IOP.TAG_ORB_TYPE;

public class _4字符串相乘 {
    //解法2：无进位相乘
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] arr = new int[n + m - 1];
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                int storeIndex = m - 1 - i  + n - 1 - j;
                arr[storeIndex] +=  (num2.charAt(i) - '0') * (num1.charAt(j) - '0');

            }
        }
        // 处理结果
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = 0;
        while (i < n + m - 1 || carry != 0) {
            int total = carry;
            if (i < n + m - 1) {
                total += arr[i];
                i++;
            }
            builder = builder.append(total % 10);
            carry = total / 10;
        }
        builder = builder.reverse();
        // 处理前导0问题
        i = 0;
        while (i < builder.length() && builder.charAt(i) == '0') {
            i++;
        }
        if (i == builder.length()) {
            return "0";
        } else {
            return builder.substring(i, builder.length());
        }
    }


    //解法1： 模拟乘法
    public static String multiply1(String num1, String num2) {
        String sum = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            // 每次相乘都要进一位
            for (int j = 0; j < num2.length() - 1 - i ; j++) {
                stringBuilder = stringBuilder.insert(0, '0');
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                int total = (num1.charAt(j) - '0') * n + carry;
                carry = total / 10;
                stringBuilder = stringBuilder.insert(0, total % 10);
            }
            if (carry > 0) {
                stringBuilder = stringBuilder.insert(0, carry);
            }
            sum = addDecimal(stringBuilder.toString(), sum);
        }

        // 对结果进行处理，去除前导0
        int i = 0;// 记录第一个不为0的位置
        while (i < sum.length() && sum.charAt(i) == '0') {
            i++;
        }
        String res;
        if (i == sum.length()) {
            res = "0";
        } else {
            res = sum.substring(i, sum.length());
        }
        return res;
    }

    public static String addDecimal(String a, String b) {
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
            res[k--] = (char)((sum % 10) + '0');
            carry = sum / 10;
        }
        //从索引k + 1开始拼接结果
        return String.valueOf(res,k + 1, res.length - 1 - k);
    }
}
