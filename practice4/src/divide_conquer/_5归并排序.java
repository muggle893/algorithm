package divide_conquer;

public class _5归并排序 {
    int[] res;
    public int[] sortArray(int[] nums) {
        res = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            res[l] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            res[k++] = nums[i++];
        }
        while (j <= r) {
            res[k++] = nums[j++];
        }
        while (l <= r) {
            nums[l] = res[l];
            l++;
        }
    }
}
