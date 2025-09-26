package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> smallPQ;
    PriorityQueue<Integer> bigPQ;
    public MedianFinder() {
        this.smallPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        this.bigPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        // 1 设左边的堆大小为n, 右边的堆大小为m，m == n
        //  1.1 如果num小于等于leftTop直接，将元素入到左边的堆
        //  1.2 如果num大于leftTop, 直接将元素入到右边的堆，再将右边的堆顶元素放到左边的堆中
        // 2 n > m时，n == m + 1
        //  2.1 若num >= leftTop，则放入右边的堆
        //  2.2 若num < leftTop, 先把左边的对堆顶元素放到右边的堆中，然后再把元素放入左边的堆
        int n = smallPQ.size();
        int m = bigPQ.size();
        if (n == m) {
            if (smallPQ.isEmpty() || num <= smallPQ.peek()){
                smallPQ.offer(num);
            } else {
                bigPQ.offer(num);
                smallPQ.offer(bigPQ.poll());
            }
        } else if (n == m + 1){
            if (num >= smallPQ.peek()) {
                bigPQ.offer(num);
            } else {
                bigPQ.offer(smallPQ.poll());
                smallPQ.offer(num);
            }
        }
    }

    public double findMedian() {
        // 设左边的堆大小为n, 右边的堆大小为m
        // 若n > m，则返回左边的堆顶元素
        // 若n == m, 则返回左边的堆顶元素和右边的堆顶元素的平均值avg
        if (smallPQ.size() == bigPQ.size() + 1) {
            return smallPQ.peek();
        } else {
            return (smallPQ.peek() + bigPQ.peek()) / 2.0;
        }
    }
}

public class _4数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
