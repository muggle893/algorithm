import java.util.Comparator;
import java.util.PriorityQueue;

public class _2将数组和减半的最少操作次数 {
    public static void main(String[] args) {
        int[] arr = {5,19,8,1};

        int step = halveArray(arr);
        System.out.println(step);
    }

    public static  int halveArray(int[] nums) {
        // 每次选择最大的数字来减少一半
        // 把数组中的所有数放到大根堆中，类型为double
        // 统计已经减掉的和，当减少到一半以下的时候就输出操作次数
        double sum = 0;
        Comparator<Double> comparator = new Comparator<Double>() {
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        };

        PriorityQueue<Double> pq = new PriorityQueue<>(comparator);

        double target = 0.0;
        for (double num : nums) {
            pq.add(num);
            target += num;
        }
        target = target / 2;
        long step = 0;
        while (sum < target) {
            Double top = pq.poll();
            step++;
            sum += top / 2;
            pq.add(top / 2);
        }
        return (int)step;
    }
}
