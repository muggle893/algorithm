package doublepointer;

import java.util.*;

public class _3找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        // 初始化hash1
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            hash1[index]++;
        }

        int count = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 进窗口
            int pos = s.charAt(right) - 'a';
            if (hash1[pos] !=0 && hash2[pos] < hash1[pos]) {
                count++;
            }
            hash2[pos]++;

            // 出窗口
            if (right - left == p.length()) {
                int pos2 = s.charAt(left) - '0';
                if (hash1[pos2] != 0 && hash2[pos2] <= hash1[pos2]) {
                    count--;
                }
                hash2[pos2]--;
                left++;
            }

            if (count == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
}
