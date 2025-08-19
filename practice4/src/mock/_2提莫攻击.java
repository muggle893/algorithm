package mock;

public class _2提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int x = timeSeries[i] - timeSeries[i - 1];
            if (x >= duration) {
                ret += duration;
            } else {
                ret += x;
            }
        }
        return ret + duration;
    }
}
