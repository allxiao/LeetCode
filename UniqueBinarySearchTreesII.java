public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private ArrayList<TreeNode> generateTrees(int lower, int upper) {
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if (lower > upper) {
            results.add(null);
        }
        // this condition is coverred by the last ELSE branch
        else if (lower == upper) {
            results.add(new TreeNode(lower));
        }
        else {
            for (int i = lower; i <= upper; i++) {
                ArrayList<TreeNode> lefts = generateTrees(lower, i - 1);
                ArrayList<TreeNode> rights = generateTrees(i + 1, upper);
                for (TreeNode left : lefts)
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        results.add(root);
                    }
            }
        }
        return results;
    }
}
