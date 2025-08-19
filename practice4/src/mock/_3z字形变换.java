package mock;

import java.util.ArrayList;
import java.util.List;

public class _3z字形变换 {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        convert(s, numRows);
    }
    public static String convert(String s, int numRows) {
        // 特殊情况处理：行数为1时直接返回原字符串
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        // 创建指定行数的字符串构建器
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        int step = -1; // 方向标记：1向下，-1向上

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            // 到达顶端或底端时改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                step = -step;
            }

            currentRow += step;
        }

        // 拼接所有行的结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
