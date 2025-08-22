package divide_conquer;

import java.util.Random;

public class _4最小的k个数 {
    public int[] smallestK(int[] arr, int k) {
        // 用快速选择算法
        // 1.0-left区间的元素个数大于k，直接去0-left再找
        // 2.0-left区间的元素等于k, 直接返回0-left区间的元素
        // 3.(0-left区间加上left+1-right-1区间的元素个数)>=k,直接返回前k个元素即可
        // 4.前k个元素中有某个元素在right~arr.length-1这个区间里面，那么就要找出
        // 在 right~arr.length-1区间里前(k - right - 0)的元素
        smallestK(arr, k, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public void smallestK(int[] arr, int k, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l - 1, right = r + 1;
        int i = l;
        int pivot = arr[new Random().nextInt(r - l + 1) + l];
        while (i < right) {
            if (arr[i] == pivot) {
                i++;
            } else if (arr[i] < pivot) {
                left++;
                swap(arr,left, i);
                i++;
            } else {
                right--;
                swap(arr, right, i);
            }
        }
        int a = left - l + 1;
        int b = right - left - 1;
        if (a > k) {
            smallestK(arr,k,l, left);
        } else if (a + b >= k) {
            return;
        } else {
            smallestK(arr,k - a - b, right, r);
        }
    }

    public void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
