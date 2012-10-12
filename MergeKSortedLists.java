public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int size = lists.size();
        int i = 0;
        // move all null lists to the end O(n)
        while (i < size) {
            if (lists.get(i) == null)
                swap(lists, i, --size);
            else
                i++;
        }
        if (size == 0)
            return null;
        // initialize min lists heap O(n)
        for (int j = (size - 2) / 2; j >= 0; j--) {
            minHeapify(lists, j, size);
        }

        // merge  O(nlogK)    K is size of lists
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        while (size > 0) {
            ListNode node = lists.get(0);
            ptr.next = node;
            ptr = ptr.next;
            node = node.next;
            ptr.next = null;
            if (node == null) {
                swap(lists, 0, --size);
            }
            else {
                lists.set(0, node);
            }
            minHeapify(lists, 0, size);
        }
        return ret.next;
    }

    private void swap(ArrayList<ListNode> lists, int i, int j) {
        ListNode tmp = lists.get(i);
        lists.set(i, lists.get(j));
        lists.set(j, tmp);
    }

    private void minHeapify(ArrayList<ListNode> lists, int i, int size) {
        if (i >= size)
            return;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left >= size && right >= size)
            return;
        int val = lists.get(i).val;
        int target = i;
        if (left < size && lists.get(left).val < val)
            target = left;
        if (right < size && lists.get(right).val < lists.get(target).val)
            target = right;
        if (target != i) {
            swap(lists, i, target);
            minHeapify(lists, target, size);
        }
    }
}
