public class _2移动零 {
    public void moveZeroes(int[] nums) {
        int i = -1, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] == 0) {
                j++;
            } else {
                if (i + 1 == j) {
                    i++;
                    j++;
                } else {
                    int tmp = nums[++i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    j++;
                }
            }
        }
    }
}
