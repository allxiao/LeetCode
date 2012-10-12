public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        while (head != null) {
            if (ptr == ret || head.val != ptr.val) {
                ptr.next = head;
                head = head.next;
                ptr = ptr.next;
                ptr.next = null;
            }
            else {
                head = head.next;
            }
        }
        return ret.next;
    }
}
