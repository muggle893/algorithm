package binarysearch;

public class _5寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int x = nums[nums.length - 1];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
