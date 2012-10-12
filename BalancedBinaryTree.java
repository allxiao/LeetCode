public class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }

    private boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        if (!isBalanced(root.left, depth))
            return false;
        int ldepth = depth[0];
        if (!isBalanced(root.right, depth))
            return false;
        int rdepth = depth[0];
        if (Math.abs(ldepth - rdepth) > 1)
            return false;
        depth[0] = (ldepth > rdepth) ? ldepth + 1 : rdepth + 1;
        return true;
    }
}
