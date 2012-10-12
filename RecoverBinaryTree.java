public class Solution {
    /* Consider the inorder traversal of BST
       if the BST is well formed, all nodes should be visited in ascending order

       for the illy formed BST as discribed in the problem, there should be
       either 1 error formed part or 2 in the traversal sequence
       eg.
             1
           /   \
          2     3
          results in    [2] [1] 3
       or
             2
           /   \
          3     1
          results in    [3] [(2)] (1)

       for the first form, the first and the second node of the illy formed pair
       are what we are looking for. for the second form, the first node of the first
       pair and the second node of the second pair are the swapped pair.

    */
    public void recoverTree(TreeNode root) {
        TreeNode[] selected = new TreeNode[2];
        TreeNode[] prev = new TreeNode[1];
        helper(root, selected, prev);
        if (selected[0] != null && selected[1] != null) {
            int tmp = selected[0].val;
            selected[0].val = selected[1].val;
            selected[1].val = tmp;
        }
    }

    public void helper(TreeNode root, TreeNode[] selected, TreeNode[] prev) {
        if (root == null)
            return;
        helper(root.left, selected, prev);
        if (prev[0] != null && prev[0].val > root.val) {
            if (selected[0] == null)
                selected[0] = prev[0];
            selected[1] = root;
        }
        prev[0] = root;
        helper(root.right, selected, prev);
    }
}
