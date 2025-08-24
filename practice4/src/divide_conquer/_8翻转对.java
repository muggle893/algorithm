package divide_conquer;

public class _8翻转对 {
    int[] tmpArr;
    public int reversePairs(int[] nums) {
        tmpArr = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1);
    }
    public int reversePairs(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int cnt = 0;
        cnt += reversePairs(nums, l, mid);
        cnt += reversePairs(nums, mid + 1, r);
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            long n1 = nums[i];
            long n2 = nums[j];
            if (n1 > 2 * n2) {
                cnt += (r - j + 1);
                i++;
            } else {
                j++;
            }
        }
        i = l;
        j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                tmpArr[k++] = nums[i++];
            } else {
                tmpArr[k++] = nums[j++];
            }
        }
        while (i <= mid) tmpArr[k++] = nums[i++];
        while (j <= r) tmpArr[k++] = nums[j++];
        while (l <= r) {
            nums[l] = tmpArr[l];
            l++;
        }
        return cnt;
    }
}
