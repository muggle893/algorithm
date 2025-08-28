package linklist;

import java.util.List;

public class _3重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //1.用快慢指针找到中间节点
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.逆序后半部分链表
        ListNode newHead = new ListNode();
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = tmp;
        }
        //3.重排节点
        ListNode p1 = head;
        ListNode p2 = newHead.next;
        while (p2 != null) {
            ListNode tmp1 = p1.next;
            ListNode tmp2 = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = tmp1;
            p2 = tmp2;
        }
    }
}
