package divide_conquer;

import java.util.Random;

public class _3数组排序 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void swap(int[] array, int p1, int p2) {
        int tmp = array[p1];
        array[p1] = array[p2];
        array[p2] = tmp;
    }

    public static void quickSort(int[] array, int left, int right){
        if (left >= right) {
            return;
        }
        int[] pos = partition(array, left, right);
        quickSort(array, left, pos[0]);
        quickSort(array, pos[1], right);
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
