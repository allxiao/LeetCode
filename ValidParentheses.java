import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0, ie = s.length(); i < ie; i++) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case ')':
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
                break;
            case ']':
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
                break;
            case '}':
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
                break;
            default:
                break;
            }
        }
        return stack.isEmpty();
    }
}
