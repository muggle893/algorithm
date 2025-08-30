package hash;

public class _2判定是否为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int pos = s1.charAt(i) - 'a';
            map1[pos]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int pos = s2.charAt(i) - 'a';
            map2[pos]++;
        }
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
