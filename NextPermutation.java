public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1)
            return;
        int left = num.length - 2;
        while (left >= 0 && num[left] >= num[left+1])
            left--;
        if (left == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }
        int i;
        for (i = num.length - 1; i > left; i--)
            if (num[i] > num[left])
                break;
        swap(num, i, left);
        reverse(num, left + 1, num.length - 1);
    }

    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start++, end--);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
