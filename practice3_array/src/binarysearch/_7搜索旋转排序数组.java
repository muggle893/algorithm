package binarysearch;

public class _7搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] arr = {3,1};
        int res = search(arr, 3 );
        System.out.println(res);
    }
    public static  int search(int[] nums, int target) {
        // 1.先搜索最小值的位置
        // 2.确定搜索区间
        // 3.搜索元素
        int left = 0, right = nums.length - 1;
        int rVal = nums[right];
        int lVal = nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < rVal) {
                right = mid;
            }
            if (nums[mid] > rVal) {
                left = mid + 1;
            }
        }
        int midIndex = left;
        if (midIndex - 1 >= 0 && target >= nums[0] && target <= nums[midIndex - 1]) {
            left = 0;
            right = midIndex - 1;
        } else {
            left = midIndex;
            right = nums.length - 1;
        }

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
