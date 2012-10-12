public class Solution {
    public int[] searchRange(int[] a, int target) {
        int start = 0, end = a.length - 1;
        int rstart = -1, rend = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                if (mid == start) {
                    rstart = start;
                    break;
                }
                end = mid;
            }
            else if (a[mid] < target)
                start = mid + 1;
            else
                end = mid -1;
        }
        start = 0;
        end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (rstart >= 0)
            return new int[] {rstart, start - 1};
        else
            return new int[] { -1, -1 };
    }

    public int[] searchRange2(int[] a, int target) {
        int x = -1, y = -1;
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == a[mid]) {
                x = (x == -1) ? mid : Math.min(x, mid);
                start = mid + 1;
            }
            else if (target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        start = 0;
        end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == a[mid]) {
                y = (y == -1) ? mid : Math.max(y, mid);
                end = mid - 1;
            }
            else if (target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[] { x, y };
    }
}
