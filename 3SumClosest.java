import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return Integer.MAX_VALUE;
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        for (int i = 0, iend = num.length - 2; i < iend; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}
