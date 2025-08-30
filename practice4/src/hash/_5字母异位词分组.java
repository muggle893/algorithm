package hash;

import java.lang.reflect.Array;
import java.util.*;

public class _5字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String tmp = new String(chs);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(tmp, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            res.add(map.get(key));
        }
        return res;
    }
}
