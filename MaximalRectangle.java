import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int column = matrix[0].length;
        int max = 0;
        
        int[] height = new int[column];
        int[] width = new int[column];
        int[] stack = new int[column];
        int sp = -1;
        for (int i = 0, ie = matrix.length; i < ie; i++) {
            // this loop can be combined with the next one
            for (int j = 0; j < column; j++)
                height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);
            
            sp = -1;
            for (int j = 0; j < column; j++) {
                while (sp >= 0 && height[stack[sp]] >= height[j])
                    sp--;
                if (sp < 0)
                    width[j] = 0;
                else
                    width[j] = stack[sp] + 1;
                stack[++sp] = j;
            }

            sp = -1;
            for (int j = column - 1; j >= 0; j--) {
                while (sp >= 0 && height[stack[sp]] >= height[j])
                    sp--;
                int right = column - 1;
                if (sp >= 0)
                    right = stack[sp] - 1;
                width[j] = right - width[j] + 1;
                stack[++sp] = j;
            }

            for (int j = 0; j < column; j++) {
                int area = height[j] * width[j];
                if (area > max)
                    max = area;
            }
        }

        return max;
    }

    public int maximalRectangleStack(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int max = 0;
        int[] height = new int[matrix[0].length];
        int[] width = new int[matrix[0].length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0, ie = matrix.length; i < ie; i++) {
            for (int j = 0, je = matrix[i].length; j < je; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);
            }

            stack.clear();
            for (int j = 0, je = height.length; j < je; j++) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[j])
                    stack.pop();
                int left = 0;
                if (!stack.isEmpty())
                    left = stack.peek() + 1;
                width[j] = left;
                stack.push(j);
            }
            stack.clear();
            for (int j = height.length - 1; j >= 0; j--) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[j])
                    stack.pop();
                int right = height.length - 1;
                if (!stack.isEmpty())
                    right = stack.peek() - 1;
                width[j] = right - width[j] + 1;
                stack.push(j);
            }
            for (int j = height.length - 1; j >= 0; j--) {
                int area = width[j] * height[j];
                if (area > max)
                    max = area;
            }
        }

        return max;
    }
}
