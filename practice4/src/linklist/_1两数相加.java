package linklist;

public class _1两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l3Tail = l3;
        l3.next = null;
        int carry = 0; // 进位标志
        while (l1 != null || l2 != null || carry != 0) {
            int total = 0;
            if (l1 != null) {
                total += l1.val;
            }
            if (l2 != null) {
                total += l2.val;
            }
            if (carry > 0) {
                total += carry;
            }
            ListNode tmp = new ListNode(total % 10);
            l3Tail.next = tmp;
            l3Tail = tmp;
            carry = total / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return l3.next;
    }
}
