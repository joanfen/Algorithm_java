package Week3;


public class ReverseList {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode reversedNode = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reversedNode = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reversedNode;
    }
}
