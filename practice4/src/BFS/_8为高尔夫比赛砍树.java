package BFS;

import javafx.util.Pair;

import java.util.*;

public class _8为高尔夫比赛砍树 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    public int cutOffTree(List<List<Integer>> forest) {
        // 1 先使用BFS，找出所有树的坐标，然后放到小根堆中，根据树的大小来排序
        // 2 然后去找从当前位置一棵树的最小距离，找到一颗树后又去找另外一棵树，以此类推
        // 3 如果不能砍完所有的树，就返回-1，否则返回砍到所有的树的最小步数
        // 4 如果找到的树的数目不是森林中树的总数那么就说明不能砍到所有的树
        int m = forest.size();
        int n = forest.get(0).size();
        visited = new boolean[m][n];
        PriorityQueue<Pair<Integer, int[]>> smallHeap = new PriorityQueue<>((e1, e2)->{
            return e1.getKey() - e2.getKey();
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int w = forest.get(i).get(j);
                if (w > 1) {
                    smallHeap.offer(new Pair<>(w, new int[]{i, j}));
                }
            }
        }
        //
        int x1 = 0, y1 = 0;
        int x2 = -1, y2 = -1;
        int sum = 0;
        while (!smallHeap.isEmpty()) {
            Pair<Integer, int[]> p = smallHeap.poll();
            x2 = p.getValue()[0];
            y2 = p.getValue()[1];
            int step = bfs(forest, x1, y1, x2, y2);
            if (step == -1) {
                return -1;
            } else {
                sum += step;
            }
            x1 = x2;
            y1 = y2;
        }
        return sum;
    }
    public int bfs(List<List<Integer>> forest, int x1, int y1, int x2, int y2) {
        // 重置visited数组
        for (boolean[] vi : visited) {
            Arrays.fill(vi, false);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});
        visited[x1][y1] = true;
        int step = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        if (x1 == x2 && y1 == y2) {
            return 0;
        }
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] t = queue.poll();
                int a = t[0];
                int b = t[1];
                for (int j = 0; j < 4; j++) {
                    int x = a + dx[j];
                    int y = b + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && forest.get(x).get(y) >= 1) {
                        if (x == x2 && y == y2) {
                            return step;
                        }
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }
}
