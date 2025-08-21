package divide_conquer;

import java.util.Arrays;
import java.util.Random;

public class _1颜色划分 {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, ++left, i++);
            } else {
                swap(nums, --right, i);
            }
        }
    }

    public void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
