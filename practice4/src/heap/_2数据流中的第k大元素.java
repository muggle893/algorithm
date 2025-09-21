package heap;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        // k个元素小根堆
        heap = new PriorityQueue<>(k);
        this.k = k;
        for (int x : nums) {
            heap.offer(x);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > this.k) {
            heap.poll();
        }
        return heap.peek();
    }
}

public class _2数据流中的第k大元素 {

}
