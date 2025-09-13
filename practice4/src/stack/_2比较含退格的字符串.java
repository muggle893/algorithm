package stack;

import java.util.LinkedList;

public class _2比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }
    public static boolean backspaceCompare(String s, String t) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                stack.push(ch);;
            } else if (ch == '#' && !stack.isEmpty()){
                stack.pop();
            }
        }
        String str1 = new StringBuilder(stack.toString()).reverse().toString();
        stack = new LinkedList<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch != '#') {
                stack.push(ch);;
            } else if (ch == '#' && !stack.isEmpty()){
                stack.pop();
            }
        }
        String str2 = new StringBuilder(stack.toString()).reverse().toString();
        if (str1.toString().equals(str2.toString())) {
            return true;
        }
        return false;
    }
}
