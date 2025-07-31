package doublepointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _4串联所有单词的子串 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> res = findSubstring(s, words);
        res.forEach((num)->{
            System.out.print(num + " ");
        });

    }
    public static  List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        int m = words.length;
        int k = words[0].length(); // 子串的长度
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            HashMap<String, Integer> sMap = new HashMap<>();
            int count = 0;
            for (int left = i, right = i + k - 1; right < n; right += k) {
                // 进窗口
                String subStr = s.substring(right - k + 1, right + 1);
                sMap.put(subStr, sMap.getOrDefault(subStr, 0) + 1);
                if (wordMap.get(subStr) != null && sMap.get(subStr) <= wordMap.get(subStr)) {
                    count++;
                }
                // 出窗口
                if ((right - left + 1) / k > m) {
                    String tmp = s.substring(left, left + k);
                    if (wordMap.get(tmp) != null && sMap.get(tmp) <= wordMap.get(tmp)) {
                        count--;
                    }
                    sMap.put(tmp, sMap.get(tmp) - 1);
                    left += k;
                }

                // 满足条件更新结果集
                if (count == m) {
                    res.add(left);
                }
            }
        }
        return res;
    }
}
