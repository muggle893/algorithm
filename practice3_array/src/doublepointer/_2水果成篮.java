package doublepointer;

import java.util.HashMap;
import java.util.Map;

public class _2水果成篮 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{0,1,2,2}));
    }
    public static  int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 1;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            // 进窗口
            if (!map.containsKey(fruits[right])) {
                map.put(fruits[right], 1);
            } else {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            }
            if (map.size() <= 2) {
                ret = Math.max(ret, right - left + 1);
            }
            // 出窗口
            while (map.size() > 2) {
                Integer fruitsSize = map.get(fruits[left]);
                if (fruitsSize - 1 == 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], fruitsSize-1);
                }
                left++;
            }
        }
        return ret;
    }
}
