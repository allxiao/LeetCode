public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd(head, n, new int[1]);
    }

    private ListNode removeNthFromEnd(ListNode head, int n, int[] pos) {
        if (head == null)
            return null;
        head.next = removeNthFromEnd(head.next, n, pos);
        pos[0]++;
        if (pos[0] == n)
            return head.next;
        else
            return head;
    }
}
