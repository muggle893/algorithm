import java.util.*;

public class _35等差数列划分II子序列 {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7};
        numberOfArithmeticSlices(arr);
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Long, List<Integer>> hash = new HashMap<>();
        int[][] dp = new int[n][n];
        // 初始化
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> indexs = hash.get(2L * nums[i] - nums[j]);
                if (indexs != null) {
                    for (int a : indexs) {
                        if (a >= 0 && a < i) {
                            dp[i][j] += dp[a][i] + 1;
                        } else {
                            break; // 优化：如果小的下标都不在i前面的话那么大的下标也一定不合法
                        }
                    }
                    count += dp[i][j];
                }
            }
            if (hash.containsKey((long)nums[i])) {
                hash.get((long)nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hash.put((long)nums[i], list);
            }
        }
        return count;
    }
}
