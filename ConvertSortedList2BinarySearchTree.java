public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }
        return sortedList2BSTHelper(new ListNode[]{head}, 0, len - 1);
    }

    private TreeNode sortedList2BSTHelper(ListNode[] head, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedList2BSTHelper(head, start, mid - 1);
        TreeNode parent = new TreeNode(head[0].val);
        parent.left = left;
        head[0] = head[0].next;
        parent.right = sortedList2BSTHelper(head, mid + 1, end);
        return parent;
    }
}
