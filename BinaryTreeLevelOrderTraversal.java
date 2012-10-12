import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return results;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            ArrayList<Integer> line = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                root = queue.poll();
                line.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                    newCount++;
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    newCount++;
                }
            }
            results.add(line);
            count = newCount;
        }

        return results;
    }
}
