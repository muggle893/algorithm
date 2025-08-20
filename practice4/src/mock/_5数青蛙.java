package mock;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _5数青蛙 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> cntMap = new HashMap<>();
        Map<Character, Character> prevElemMap = new HashMap<>();
        String s = "croak";
        for (int i = 1; i < s.length(); i++) {
            prevElemMap.put(s.charAt(i), s.charAt(i - 1));
        }
        int max_frog = 0;
        int current_frog = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                current_frog++;
                max_frog = Math.max(max_frog, current_frog);
            } else {
                // 不合法的序列要返回-1
                if (cntMap.getOrDefault(prevElemMap.get(c), 0) <= cntMap.getOrDefault(c, 0)) {
                    return -1;
                }
                if (c == 'k') {
                    current_frog--;
                }
            }
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        // 所有的字符数量最后都要相等
        int k = cntMap.getOrDefault('c', 0);
        for (int i = 0; i < s.length(); i++) {
            if (cntMap.getOrDefault(s.charAt(i), 0) != k) {
                return -1;
            }
        }

        return max_frog;
    }
}
