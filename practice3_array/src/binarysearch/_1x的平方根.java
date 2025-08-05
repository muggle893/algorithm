package binarysearch;

public class _1x的平方根 {
    public int mySqrt(int x) {
        // 找一个数字k, k^2 <= x && (k + 1^2) > x
        // 这个数字从哪里开始找呢？
        // 从0-x二分查找试试
        long left = 0, right = x;
        while (left <= right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else if ((mid + 1)*(mid + 1) <= x){
                left = mid + 1;
            }
        }
        return -1;
    }
}
