public class Solution {
    public int trap(int[] a) {
        int left = 0, right = a.length - 1;
        int result = 0;
        if (a.length < 3)
            return 0;
        while (left + 1 < right) {
            while (left < right - 1 && a[left + 1] >= a[left])
                left++;
            while (right > left + 1 && a[right - 1] >= a[right])
                right--;
            if (left + 1 >= right)
                break;
            if (a[left] <= a[right]) {
                int i = left + 1;
                while (i < right && a[i] <= a[left]) {
                    result += a[left] - a[i];
                    i++;
                }
                left = i;
            }
            else {
                int i = right - 1;
                while (i > left && a[i] <= a[right]) {
                    result += a[right] - a[i];
                    i--;
                }
                right = i;
            }
        }
        return result;
    }
}
