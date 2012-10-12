import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                results.add(root.val);
                root = root.right;
            }
        }
        return results;
    }
}
