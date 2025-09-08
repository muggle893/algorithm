package string;

public class _1最长公共前后缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean validChar = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    validChar = false;
                    break;
                }
            }
            if (validChar) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
