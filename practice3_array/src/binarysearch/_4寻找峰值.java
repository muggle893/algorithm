package binarysearch;

public class _4寻找峰值 {
    public int findPeakElement(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPeakElem(nums, mid)) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }
        return -1;
    }
    public boolean isPeakElem(int[] nums, int index) {
        // 左边满足递增，右边要满足递减
        if (index == 0 || nums[index] > nums[index - 1]) {
            if (index == nums.length - 1 || nums[index] > nums[index + 1]) {
                return true;
            }
        }
        return false;
    }
}
