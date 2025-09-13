package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _1删除字符串中所有相邻重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public  static String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (stack.isEmpty() || stack.peek() != str[i]) {
                stack.push(str[i]);
            } else if (stack.peek() == str[i]) {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder =  builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
