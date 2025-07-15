import java.util.Arrays;

public class 有效三角形的个数 {
    public static void main(String[] args) {
        int[] arr = {48,66,61,46,94,75};
        triangleNumber(arr);
    }
    public static int triangleNumber(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        // 1.排序
        Arrays.sort(nums);

        // 2.初始化指针
        int k = nums.length - 1;
        int i = 0;
        int j = nums.length - 2;

        // 3.统计组合数目
        int total = 0;
        while (k >= 2) {
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    total += j - i;
                    j--;
                } else {
                    i++;
                }
            }

            // 更新变量, 准备下一轮循环
            k--;
            i = 0;
            j = k - 1;
        }
        return total;
    }
}
