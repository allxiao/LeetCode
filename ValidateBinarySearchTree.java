import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (prev != null && prev.val >= root.val)
                    return false;
                prev = root;
                root = root.right;
            }
        }
        return true;
    }
}
