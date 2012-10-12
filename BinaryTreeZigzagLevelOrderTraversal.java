import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode node) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (node == null)
            return results;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reverse = false;
        queue.offer(node);
        int count = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            ArrayList<Integer> line = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                node = queue.poll();
                line.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    newCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    newCount++;
                }
            }
            if (reverse) {
                int i = 0, j = line.size() - 1;
                while (i < j) {
                    Integer tmp = line.get(i);
                    line.set(i, line.get(j));
                    line.set(j, tmp);
                    i++;
                    j--;
                }
            }
            results.add(line);
            reverse = !reverse;
            count = newCount;
        }

        return results;
    }
}
