package code_6_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leecode93_复原IP地址 {
    private List<String> res = new ArrayList<>();
    private String path = "";
    private int ipNumCount = 0; // 保存ip中的整数个数
    public List<String> restoreIpAddresses(String s) {
        backtrace(s, 0);
        return res;
    }

    @Test
    public void test() {
        res = restoreIpAddresses("25525511135");
        for (String s : res) {
            System.out.println(s);
        }
    }

    private boolean isLegalNum(String num) {
        // 不能包含前导0
        if (num.length() > 1 && num.charAt(0) == '0') {
            return false;
        }
        // 判断范围
        int val = Integer.valueOf(num);
        if (val >= 0 && val <= 255) {
            return true;
        }
        return false;
    }
    private void backtrace(String s, int startIndex) {
        if (startIndex == s.length() && ipNumCount == 4) {
            // 收集结果
            res.add(new String(path));
            return;
        }
        // 1-3位数字，注意前导0问题
        for (int i = startIndex + 1; i <= startIndex + 3 && i <= s.length(); i++) {
            // 4层了就不能继续往下了
            if (ipNumCount == 4) {
                break;
            }
            // 截取数字
            String num = s.substring(startIndex, i);
            // 超过三位数的数字不能作为ip的一部分，比如4位数字分为有前导0和没有前导0的情况
            // 这两种情况都不满足条件
            if (num.length() > 3) {
                break;
            }
            if (!isLegalNum(num)) {
                continue;
            }
            ipNumCount++;
            int endIndex = path.length();
            path += s.substring(startIndex, i);
            if (ipNumCount < 4) {
                path += ".";
            }
            backtrace(s, i);
            ipNumCount--;
            path = path.substring(0, endIndex);
        }
    }
}
