package bit_compute;

public class _5消失的两个数字 {
    public static void main(String[] args) {
        int[] arr = {2,3};
        missingTwo(arr);
    }
    public static int[] missingTwo(int[] nums) {
        int x = 0;
        int[] res = {0, 0};
        for (int i = 1; i <= nums.length + 2; i++) {
            x ^= i;
        }
        for (int num : nums) {
            x ^= num;
        }
        int k = 0;
        while (true) {
            if (((x >> k) & 1) == 1) {
                break;
            }else {
                k++;
            }
        }
        for (int num : nums) {
            if(((num >> k) & 1) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        for (int i = 1; i <= nums.length + 2; i++) {
            if(((i >> k) & 1) == 1) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
