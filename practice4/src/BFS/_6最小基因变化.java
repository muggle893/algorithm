package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _6最小基因变化 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> visSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] change = {'A', 'G', 'C', 'T'};
        // 先将基因库中的每一个序列都加入到bankSet中
        for (String s : bank) {
            bankSet.add(s);
        }
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        int step = 0;
        queue.offer(startGene);
        visSet.add(startGene);
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String s = queue.poll();
                for (int j = 0; j < 8; j++) {
                    char[] chars = s.toCharArray();
                    for (int k = 0; k < 4; k++) {
                        chars[j] = change[k];
                        String tmp = new String(chars);
                        if (!visSet.contains(tmp) && bankSet.contains(tmp)) {
                            if (tmp.equals(endGene)) {
                                return step;
                            }
                            visSet.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
