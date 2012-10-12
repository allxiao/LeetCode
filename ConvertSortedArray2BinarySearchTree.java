public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(num[start]);
        int mid = start + (end - start) / 2;
        TreeNode parent = new TreeNode(num[mid]);
        parent.left = sortedArrayToBSTHelper(num, start, mid - 1);
        parent.right = sortedArrayToBSTHelper(num, mid + 1, end);

        return parent;
    }
}
