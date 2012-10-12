public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;
        int len = 0;
        ListNode tmp = head;
        ListNode tail = null;
        while (tmp != null) {
            len++;
            if (tmp.next == null)
                tail = tmp;
            tmp = tmp.next;
        }
        n = n % len;
        if (n == 0)
            return head;
        tmp = head;
        for (int i = len - n - 1; i > 0; --i) {
            tmp = tmp.next;
        }
        ListNode ret = tmp.next;
        tmp.next = null;
        tail.next = head;
        return ret;
    }
}
