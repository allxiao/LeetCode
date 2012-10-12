public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart == pend)
            return new TreeNode(preorder[pstart]);
        if (pstart > pend)
            return null;
        TreeNode parent = new TreeNode(preorder[pstart]);
        int pos = istart;
        for (; pos <= iend; pos++)
            if (inorder[pos] == parent.val)
                break;
        int leftcount = pos - istart;
        if (leftcount > 0)
            parent.left = buildTree(preorder, pstart + 1, pstart + leftcount, inorder, istart, pos - 1);
        if (pos < iend)
            parent.right = buildTree(preorder, pstart + leftcount + 1, pend, inorder, pos + 1, iend);
        return parent;
    }
}
