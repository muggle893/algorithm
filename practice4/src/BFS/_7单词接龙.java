package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _7单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        // 用来保存已经访问过的字符串
        HashSet<String> vis = new HashSet<>();
        // 用set来保存一遍在wordList中的字符串
        HashSet<String> wd = new HashSet<>();
        for (String s : wordList) {
            wd.add(s);
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wd.contains(endWord)) {
            return 0;
        }
        Queue<String> queue  = new LinkedList<>();
        int step = 0;
        vis.add(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            step++;
            while (sz > 0) {
                String poll = queue.poll();
                for (int i = 0; i < n; i++) {
                    char[] str = poll.toCharArray();
                    for (int j = 0; j < 26; j++) {
                        str[i] = (char)('a' + j);
                        String tmp = String.valueOf(str);
                        if (!vis.contains(tmp) && wd.contains(tmp)) {
                            if (tmp.equals(endWord)) return step + 1;
                            vis.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
                sz--;
            }
        }
        return 0;
    }
}
