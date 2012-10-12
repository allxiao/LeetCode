public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            ListNode next = head.next;
            if (head.val != prev.val) {
                if (prev.next == head) {
                    ptr.next = prev;
                    ptr = ptr.next;
                    ptr.next = null;
                }
                prev = head;
            }
            head = next;
        }
        if (prev.next == null)
            ptr.next = prev;
        return ret.next;
    }
}
