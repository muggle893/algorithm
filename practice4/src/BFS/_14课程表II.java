package BFS;

import java.util.*;

public class _14课程表II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1 建图
        // 2 计算各个节点的入度
        // 3 进行拓扑排序
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] res = new int[numCourses];
        int k = 0;// 记录res的下标
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res[k++] = i;
            for (int j : graph.get(i)) {
                in[j]--;
                if (in[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        for (int val : in) {
            if (val != 0) {
                return new int[]{};
            }
        }
        return res;
    }
}
