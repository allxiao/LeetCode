import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] width = new int[height.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i])
                stack.pop();
            if (stack.isEmpty())
                width[i] = width.length - 1;
            else
                width[i] = stack.peek() - 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i])
                stack.pop();
            int left = 0;
            if (stack.isEmpty())
                left = 0;
            else
                left = stack.peek() + 1;
            stack.push(i);
            width[i] -= (left - 1);
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int area = height[i] * width[i];
            if (area > max)
                max = area;
        }
        return max;
    }
}
