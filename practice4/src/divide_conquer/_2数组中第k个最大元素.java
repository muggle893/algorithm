package divide_conquer;

import java.util.Random;

public class _2数组中第k个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    public int findKthLargest(int[] nums, int k, int left, int right) {
        int[] pos = partition(nums, left, right );
        int res = 0;
        int b = pos[1] - pos[0] - 1;
        int c = right - pos[1] + 1;
        if (c >= k) {
            res = findKthLargest(nums, k, pos[1], right);
        } else if (b + c >= k){
            return nums[pos[0] + 1];
        } else {
            res = findKthLargest(nums,k - b - c,left, pos[0]);
        }
        return res;
    }
    public static void swap(int[] array, int p1, int p2) {
        int tmp = array[p1];
        array[p1] = array[p2];
        array[p2] = tmp;
    }

    private static int[] partition(int[] array, int left, int right) {
        int pivot = array[new Random().nextInt(right - left + 1) + left];  // 基准值取左端
        int pos1 = left - 1, pos2 = right + 1;
        int i = left;
        while (i < pos2) {
            if (array[i] == pivot) {
                i++;
            } else if (array[i] < pivot) {
                swap(array, ++pos1, i++);
            } else {
                swap(array, --pos2, i);
            }
        }
        return new int[]{pos1, pos2};
    }
}
