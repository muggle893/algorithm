package linklist;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _4合并k个升序链表 {
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode newHead = new ListNode();
        ListNode last = newHead;
        ListNode[] pt = Arrays.copyOf(lists, lists.length);
        while (true) {
            ListNode minNode = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (pt[i] != null) {
                    if (minNode == null || pt[i].val < minNode.val) {
                        minNode = pt[i];
                        index = i;
                    }
                }
            }
            if (index == -1) {
                break;
            }
            last.next = minNode;
            last = minNode;
            pt[index] = pt[index].next;
            last.next = null;
        }
        return newHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        ListNode newHead = new ListNode();
        ListNode last = newHead;
        ListNode[] pt = Arrays.copyOf(lists, lists.length);
        // 先将k个节点放入优先级队列中
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
            last.next = minNode;
            last = minNode;
            last.next = null;
        }
        return newHead.next;
    }
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists4(lists, 0, lists.length - 1);
    }
    public ListNode mergeKLists4(ListNode[] lists,int l,int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode newHead = new ListNode();
        ListNode last = newHead;
        ListNode left = mergeKLists4(lists, l, mid);
        ListNode right = mergeKLists4(lists, mid + 1, r);
        while (left != null && right != null) {
            if (left.val <= right.val) {
                last.next = left;
                left = left.next;
                last = last.next;
                last.next = null;
            } else {
                last.next = right;
                right = right.next;
                last = last.next;
                last.next = null;
            }
        }
        if (left != null) last.next = left;
        if (right != null) last.next = right;
        return newHead.next;
    }
}
