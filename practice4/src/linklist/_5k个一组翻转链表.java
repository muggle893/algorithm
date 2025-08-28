package linklist;

public class _5k个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode subList = head;
        for (int i = 0; i < k; i++) {
            if (subList != null){
                subList = subList.next;
            }
            else{
                return head;
            }
        }
        // 逆序前k个，再拼接上后面的子链表
        ListNode newHead = new ListNode();
        ListNode last = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        last.next = reverseKGroup(subList, k);
        return newHead.next;
    }
}
