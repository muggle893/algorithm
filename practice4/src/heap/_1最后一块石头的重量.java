package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1最后一块石头的重量 {
    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        lastStoneWeight(arr);
    }
    /**
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        // 建立一个大根堆，模拟题目所说的过程
        // 当堆里面的元素个数小于2的时候就停止循环
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() >= 2) {
            // 拿出两个最大的石头
            int newWeight = heap.poll() - heap.poll();
            if (newWeight > 0) {
                heap.offer(newWeight);
            }
        }
        if (heap.size() > 0) {
            return heap.poll();
        }
        return 0;
    }
}
