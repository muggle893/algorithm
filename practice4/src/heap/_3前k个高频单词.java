package heap;

import java.util.*;

public class _3前k个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        // 1.使用优先级队列(nlogk)
        //      1.1 先把全部单词的频率记录下来放到一个map中
        //      1.2 然后遍历map中的所有元素，根据频率这个字段来建立小根堆
        //      1.3 若单词的频率一样则堆顶的元素为字典序比较大的
        //      1.4 先把元素入堆，如果优先级队列中的元素个数已经大于k，那么就弹出堆顶元素



        // 2.使用快速选择算法(n)
        //      2.1 先把全部单词的频率记录下来
        //      2.2 按照单词的频率为基准进行快速选择算法找出前k个频率最高的单词
        return topKFrequent1(words, k);
    }

    public List<String> topKFrequent1(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        // 统计单词频次
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 拿结果
        ArrayList<String> list = new ArrayList<>();
        while (heap.size() > 0) {
            list.add(heap.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }

}
