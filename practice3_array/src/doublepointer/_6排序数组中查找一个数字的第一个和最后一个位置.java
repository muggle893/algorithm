package doublepointer;

public class _6排序数组中查找一个数字的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        // 思路：
        // 查找最后一个位置去右区间找
        // 比如[5,7,7,8,8,10]，找到8之后还要去右边区间找8，同时更新maxIndex
        // 查找第一个位置去左区间找
        // 比如[5,7,7,7,8,10]，找到7之后还要去左边区间找7，同时更新minIndex
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                minIndex = Math.min(minIndex, mid);
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                maxIndex = Math.max(maxIndex, mid);
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 处理结果
        res[0] = minIndex;
        res[1] = maxIndex;
        if (minIndex == Integer.MAX_VALUE) {
            res[0] = -1;
        }
        if (maxIndex == Integer.MIN_VALUE) {
            res[1] = -1;
        }
        return res;
    }
}
