package mock;

public class _1替换所有的问号 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                for (char ch = 'a'; ch <= 'w'; ch++) {
                    boolean canReplace = true;
                    if (i - 1 >= 0 && ch == sb.charAt(i - 1)) {
                        canReplace = false;
                    }
                    if (i + 1 < s.length() && ch == s.charAt(i + 1)) {
                        canReplace = false;
                    }
                    if (canReplace) {
                        sb = sb.append(ch);
                        break;
                    }
                }
            } else {
                sb = sb.append(c);
            }
        }
        return sb.toString();
    }
}
