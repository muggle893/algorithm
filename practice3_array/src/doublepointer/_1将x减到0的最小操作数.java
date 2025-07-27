package doublepointer;

public class _1将x减到0的最小操作数 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,
                10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
    }
    public static int minOperations(int[] nums, int x) {
        int total = 0;
        int target = 0;
        for (int n : nums) {
            total += n;
        }
        target = total - x;
        if (target < 0) {
            return -1;
        }
        int sum = 0;
        int maxLen = -1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            // 进窗口
            sum += nums[right];
            // 出窗口
            while (sum > target) {
                sum -= nums[left++];
            }
            // 判断窗口是否符合条件
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        if (maxLen == -1) {
            return -1;
        }
        return nums.length - maxLen;
    }
}
