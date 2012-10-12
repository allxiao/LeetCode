public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int result = carry;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.val;
                l2 = l2.next;
            }
            carry = result / 10;
            ListNode newNode = new ListNode(result % 10);
            ptr.next = newNode;
            ptr = newNode;
        }
        if (carry > 0)
            ptr.next = new ListNode(carry);
        return ret.next;
    }
}
