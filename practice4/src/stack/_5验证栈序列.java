package stack;

import java.util.LinkedList;
import java.util.Stack;

public class _5验证栈序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0 ; // i 指向pushed数组元素，j指向poped数组元素
        LinkedList<Integer> st = new LinkedList<>();
        while (i < pushed.length) {
            st.push(pushed[i++]);
            while (!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
