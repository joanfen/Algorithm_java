package List;


public class LinkedListDemo {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        reverseKGroupList(node, 2);
    }

    /**
     * K 个一组反转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupList(ListNode head, int k) {
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode pre = guard;
        while (head != null) {

            ListNode start = head;
            for (int i = 0; i < k - 1; i++) {
                head = head.next;
                if (head == null) {
                    return guard.next;
                }
            }
            ListNode end = head;
            reverseList(pre, start, end);
            pre = start;
            head = start.next;

        }

        return guard.next;
    }

    private static ListNode reverseList(ListNode pre, ListNode head, ListNode tail) {
        if(head == null || head.next == null) return head;
        ListNode reversedHead = head;
        ListNode reversedTail = head;
        ListNode curr = head.next;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = reversedHead;
            reversedHead = curr;
            reversedTail.next = next;
            if (curr == tail) {
                break;
            }
            curr = next;
        }
        pre.next = reversedHead;
        return pre;
    }
}
