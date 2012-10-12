public class Solution {
    public String getPermutation(int n, int k) {
        char[] seq = new char[n];
        for (int i = 1; i <= n; i++)
            seq[i - 1] = (char)(i + '0');
        while (--k > 0)
            nextPermutation(seq);
        return new String(seq);
    }

    public void nextPermutation(char[] seq) {
        if (seq.length == 1)
            return;
        int left = seq.length - 2;
        while (left >= 0 && seq[left] >= seq[left+1])
            left--;
        if (left < 0) {
            reverse(seq, 0, seq.length - 1);
            return;
        }
        int i;
        for (i = seq.length - 1; i > left; i--)
            if (seq[i] > seq[left])
                break;
        swap(seq, i, left);
        reverse(seq, left + 1, seq.length - 1);
    }

    private void reverse(char[] seq, int start, int end) {
        while (start < end)
            swap(seq, start++, end--);
    }

    private void swap(char[] seq, int i, int j) {
        char tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}
