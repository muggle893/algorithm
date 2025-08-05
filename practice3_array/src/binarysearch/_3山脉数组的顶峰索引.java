package binarysearch;

public class _3山脉数组的顶峰索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (isPeakNum(arr, mid)) {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public boolean isPeakNum(int[] arr, int index) {
        if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
            return true;
        }
        return false;
    }
}
