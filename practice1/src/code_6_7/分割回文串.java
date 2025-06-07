package code_6_7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 分割回文串 {
    private int trimLen = 0;
    private ArrayList<String> subRes = new ArrayList<>();
    private ArrayList<ArrayList<String>> res = new ArrayList<>();
    @Test
    public void test() {
        partition("google");
    }

    public String[][] partition(String s) {
        backtrace(s, 0);
        // 将结果转换成String数组
        String[][] ss = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int len = res.get(i).size();
            String[] tmpArr = new String[len];
            for (int j = 0; j < len; j++) {
                tmpArr[j] = res.get(i).get(j);
            }
            ss[i] = tmpArr;
        }
        return ss;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    private void backtrace(String s, int startIndex) {
        if (trimLen == s.length()) {
            // 收集结果
            ArrayList<String> tmp = new ArrayList<>(subRes);
            res.add(tmp);
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            // 分割一个子串, 长度为1, 2, ...(i - startIndex)
            String subStr = s.substring(startIndex, i);
            if (!isPalindrome(subStr)) {
                continue;
            }
            subRes.add(subStr);
            trimLen += (i - startIndex);
            backtrace(s, i);
            subRes.removeLast();
            trimLen -= (i - startIndex);
        }
    }
}
