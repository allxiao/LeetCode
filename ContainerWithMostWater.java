public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max)
                max = area;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}
