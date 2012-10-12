public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart == iend)
            return new TreeNode(inorder[istart]);
        if (istart > iend)
            return null;
        TreeNode parent = new TreeNode(postorder[pend]);
        int pos = istart;
        for (; pos <= iend; pos++)
            if (inorder[pos] == parent.val)
                break;
        int leftcount = pos - istart;
        if (leftcount > 0)
            parent.left = buildTree(inorder, istart, pos - 1, postorder, pstart, pstart + leftcount - 1);
        if (pos + 1 <= iend)
            parent.right = buildTree(inorder, pos + 1, iend, postorder, pstart + leftcount, pend - 1);
        
        return parent;
    }
}
