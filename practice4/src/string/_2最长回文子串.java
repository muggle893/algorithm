package string;

public class _2最长回文子串 {
    public String longestPalindrome(String s) {
        // 思路：
        // 暴力解法：把全部的子串找出来，然后统计最长的回文子串
        // 中心拓展法：因为题目要求我们找的是回文子串，所以固定一个中心点向左右找，每次判定的事件复杂度是O(1)
        int maxLen = 1;
        String ans = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心找奇数的回文子串
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // 更新最长子串
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            // 以i和i + 1为起点找偶数的回文子串
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // 更新最长子串
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return ans;
    }
}
