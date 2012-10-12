public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode ret = new ListNode(0);
        ListNode reversed = new ListNode(0);
        ListNode ptr = ret;
        ListNode reversedTail = null;
        int pos = 1;
        while (head != null) {
            ListNode next = head.next;
            if (pos < m || pos > n) {
                ptr.next = head;
                ptr = ptr.next;
                ptr.next = null;
            }
            else {
                head.next = reversed.next;
                reversed.next = head;
                if (pos == m) {
                    reversedTail = head;
                }
                if (pos == n) {
                    ptr.next = reversed.next;
                    ptr = reversedTail;
                }
            }
            pos++;
            head = next;
        }
        return ret.next;
    }
}
