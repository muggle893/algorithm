package prefixsun;

import java.util.HashMap;

public class _4和可被k整除的子数组 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0 % k, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = (sum % k + k) % k;
            count += hashMap.getOrDefault(r, 0);
            hashMap.put(r, hashMap.getOrDefault(r, 0) + 1);
        }
        return count;
    }
}
