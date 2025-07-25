public class _7最长连续1个数III {
    public int longestOnes(int[] nums, int k) {
        int usedK = 0;
        int l = 0;
        int r = l;
        int maxLen = 0;
        while (l < nums.length) {
            // 将r指针向右移动，来寻找区间
            while (r < nums.length) {
                if (nums[r] == 1) {
                       r++;
                } else if (nums[r] == 0 && usedK < k) {
                    r++;
                    usedK++;
                } else {
                    break;
                }
            }
            // 更新长度
            if (r - l > maxLen) {
                maxLen = r - l;
            }
            // 更新l
            if (nums[l] == 0) {
                usedK--;
            }
            l++;
        }
        return maxLen;
    }
}
