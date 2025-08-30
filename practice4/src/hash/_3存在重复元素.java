package hash;

import java.util.HashMap;
import java.util.HashSet;

public class _3存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }
}
