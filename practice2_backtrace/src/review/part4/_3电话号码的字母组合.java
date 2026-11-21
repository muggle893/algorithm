package review.part4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3电话号码的字母组合 {

    Map<Character, String> dict;
    public void initDict() {
        dict = new HashMap<Character, String>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

    }
    char[] s;
    int n;
    List<String> res = new ArrayList<String>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        initDict();
        s = digits.toCharArray();
        n = digits.length();
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        if (i == n) {
            res.add(String.valueOf(path.toString()));
            return;
        }
        char[] cs = dict.get(s[i]).toCharArray();
        for (int j = 0; j < cs.length; j++) {
            path.append(cs[j]);
            dfs(i + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
