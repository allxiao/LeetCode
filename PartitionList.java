public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0);
        ListNode gte = new ListNode(0);
        ListNode ltptr = lt, gteptr = gte;
        while (head != null) {
            if (head.val < x) {
                ltptr.next = head;
                head = head.next;
                ltptr = ltptr.next;
                ltptr.next = null;
            }
            else {
                gteptr.next = head;
                gteptr = gteptr.next;
                head = head.next;
                gteptr.next = null;
            }
        }
        ltptr.next = gte.next;
        return lt.next;
    }
}
