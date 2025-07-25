import java.util.HashSet;

public class _6无重复字符的长连续子字符串 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int maxLen = 1;// 默认为1
        int i = 0;
        int j = i + 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (i < n) {
            // 找区间
            while (j < n && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            // 更新长度
            if (maxLen < j - i) {
                maxLen = j - i;
            }
            // 重新更新区间
            set.remove(s.charAt(i));
            i++;
        }
        return maxLen;
    }
}
