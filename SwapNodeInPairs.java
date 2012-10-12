public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            ptr.next = head.next;
            ptr = ptr.next;
            ptr.next = head;
            ptr = ptr.next;
            ptr.next = null;
            head = next;
        }
        ptr.next = head;
        return ret.next;
    }
}
