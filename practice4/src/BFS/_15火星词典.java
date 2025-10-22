package BFS;

import java.util.*;

public class _15火星词典 {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        String res = alienOrder(words);
        System.out.println(res);
    }
    public static String alienOrder(String[] words) {
        // 1.words[i]和后面的全部words[j]对比， j > i
        // 2.得到字符的先后顺序
        // 3.需要对字符的先后顺序建立一个图
        // 4.对图进行拓扑排序


        Map<Character, Integer> in = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        // 初始化各个节点的入度
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!in.containsKey(word.charAt(i))) {
                    in.put(word.charAt(i), 0);
                }

            }
        }
        // 建图并统计各个节点的入度
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int n = Math.min(s1.length(), s2.length());
            // 对比字符的大小, 找到第一个不一样的字符
            int k = 0;
            for (k = 0; k < n; k++) {
                char ch1 = s1.charAt(k);
                char ch2 = s2.charAt(k);
                // ch1 != ch2说明找到了, 将ch2放到ch1的邻接表中
                if (ch1 != ch2) {
                    Set<Character> adjList = null;
                    if (!graph.containsKey(ch1)) {
                        graph.put(ch1, new HashSet<>());
                    }
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        in.put(ch2, in.get(ch2) + 1);
                    }
                    break;
                }
            }
            // 遍历到了最后且s1比s2长的情况就返回"", 题目给的字典序是错误的
            if (k == s2.length() && k < s1.length()) {
                return "";
            }

        }
        // 找入度为0的节点作为起始点
        Set<Character> inNodeSet = in.keySet();
        for (Character c : inNodeSet) {
            if (in.get(c) == 0) {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();// 保存最后的排序序列
        // 拓扑排序
        while (!q.isEmpty()) {
            Character node = q.poll();
            sb.append(node);// 将结点加入拓扑排序序列中
            Set<Character> adjList = graph.get(node);
            // 最后一个出度为0的节点没有邻接表所以要判断adjList是否为null
            if (adjList != null) {
                // 将邻接的节点入度-1
                for (Character adjNode : adjList) {
                    in.put(adjNode, in.get(adjNode) - 1);
                    // 如果节点的入度为0就将节点入队
                    if (in.get(adjNode) == 0) {
                        q.offer(adjNode);
                    }
                }
            }
        }

        // 序列不合法就返回""
        for (Character key : graph.keySet()) {
            if (in.get(key) != 0) {
                return "";
            }
        }

        // 返回结果
        return sb.toString();
    }
}
