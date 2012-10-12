import java.util.ArrayList;

// It might be better to traverse from top level to bottom level and then reverse the results

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int treeHeight = height(root);
        for (int i = treeHeight - 1; i >= 0; i--) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            traverseLevel(root, i, values);
            results.add(values);
        }

        return results;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return lheight > rheight ? lheight + 1 : rheight + 1;
    }

    private void traverseLevel(TreeNode node, int level, ArrayList<Integer> values) {
        if (node == null)
            return;
        if (level == 0)
            values.add(node.val);
        else {
            traverseLevel(node.left, level - 1, values);
            traverseLevel(node.right, level - 1, values);
        }
    }
}
