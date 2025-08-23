package divide_conquer;

import java.util.*;

public class _7计算右侧小于当前元素的个数 {
    List<Integer> res;
    int[] arr;
    int[] index;
    int[] tmpIndex;
    public List<Integer> countSmaller(int[] nums) {
        arr = new int[nums.length];
        index = new int[nums.length];
        tmpIndex = new int[nums.length];
        res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
            res.add(0);
        }
        countSmaller(nums, 0, nums.length - 1);
        return res;
    }

    public void countSmaller(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        countSmaller(nums, l, mid);
        countSmaller(nums, mid + 1, r);
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                int pos = index[i];
                res.set(pos, res.get(pos) + (r - j + 1));
                arr[k] = nums[i];
                tmpIndex[k++] = index[i++];
            } else {
                arr[k] = nums[j];
                tmpIndex[k++] = index[j++];
            }
        }
        while (i <= mid) {
            arr[k] = nums[i];
            tmpIndex[k++] = index[i++];
        }
        while (j <= r) {
            arr[k] = nums[j];
            tmpIndex[k++] = index[j++];
        }
        while (l <= r) {
            nums[l] = arr[l];
            index[l] = tmpIndex[l];
            l++;
        }
    }
}
