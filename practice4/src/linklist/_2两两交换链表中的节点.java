package linklist;

public class _2两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode p1 = head;
        ListNode p2 = null;
        if (p1 != null) p2 = p1.next;
        while (p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            tail.next = p2;
            p2.next = p1;
            p1.next = null;
            tail = p1;
            p1 = tmp;
            if (p1 != null) p2 = p1.next;
        }
        tail.next = p1;
        return newHead.next;
    }
}
