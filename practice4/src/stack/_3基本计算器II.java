package stack;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.xml.stream.events.Characters;
import java.util.LinkedList;

public class _3基本计算器II {
    public static void main(String[] args) {
        new _3基本计算器II().calculate(" 3+5 / 2 ");
    }
    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList<>();
        char op = '+';
        int i = 0;
        int n = s.length();
        while (i < n) {
            // 如果是操作符则更新操作符
            if (s.charAt(i) == ' ') {
                i++;
            }
            else if (isOperator(s.charAt(i))) {
                op = s.charAt(i);
                i++;
            } else {
                // 从i开始去找数字
                int j = i;
                while (j < n && !isOperator(s.charAt(j))) {
                    j++;
                }
                int tmp = Integer.parseInt(s.substring(i, j).trim());
                if (op ==  '+') {
                    nums.push(tmp);
                } else if (op == '-') {
                    nums.push(tmp * -1);
                } else if (op == '*') {
                    Integer top = nums.pop();
                    nums.push(top * tmp);
                } else {
                    Integer top = nums.pop();
                    nums.push(top / tmp);
                }
                i = j;
            }
        }
        int total = 0;
        while (nums.size() > 0) {
            total += nums.pop();
        }
        return total;
    }
    public int calculate(int n1, int n2, char op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return -1;
    }
    public boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }
}
