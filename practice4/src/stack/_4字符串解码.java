package stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class _4字符串解码 {
    public static void main(String[] args) {
        String s = new _4字符串解码().decodeString(
                "3[a]2[bc]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        // 1.没有遇到]就将字符入栈
        // 2.如果遇到]就要进行处理，将字符出栈直到遇到[，然后将子串再重复K次
        // k为方括号前的数字
        ArrayList<Character> str = new ArrayList<>();
        LinkedList<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } else {
                while (st.peek() != '[') {
                    str.add(st.pop());
                }
                st.pop();
                StringBuilder builder = new StringBuilder();
                // 找数字
                while (st.size() > 0 && Character.isDigit(st.peek())) {
                    builder.insert(0, st.pop());
                }
                int k = Integer.parseInt(builder.toString());
                // 将字符串入栈，重复k次
                while (k > 0) {
                    for (int j = str.size() - 1;j >= 0; j--) {
                        st.push(str.get(j));
                    }
                    k--;
                }
                str.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
