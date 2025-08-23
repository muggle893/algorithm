package divide_conquer;

public class _6逆序对的总数 {
    int[] arr;
    public int reversePairs(int[] record) {
        arr = new int[record.length];
        return reversePairs(record, 0, record.length - 1);
    }

    public int reversePairs(int[] record, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int sum1 = reversePairs(record,l, mid);
        int sum2 = reversePairs(record, mid + 1, r);
        // 合并(合并成一个从小到大的数据），并统计逆序对
        int sum3 = 0;
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (record[i] <= record[j]) {
                arr[k++] = record[i++];
            } else {
                sum3 += mid - i + 1;
                arr[k++] = record[j++];
            }
        }
        while (i <= mid) arr[k++] = record[i++];
        while (j <= r) arr[k++] = record[j++];
        k = l;
        while (l <= r) {
            record[l++] = arr[k++];
        }
        return sum1 + sum2 + sum3;
    }
}
