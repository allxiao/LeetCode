public class Solution {
    public int maxHeight(TreeNode root) {
        if (root == null)
            return 0;
        int ldepth = maxHeight(root.left);
        int rdepth = maxHeight(root.right);
        return ldepth > rdepth ? ldepth + 1 : rdepth + 1;
    }
}
