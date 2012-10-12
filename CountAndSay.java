public class Solution {
    public String countAndSay(int n) {
        String start = "1";
        for (int i = 1; i < n; i++)
            start = countAndSay(start);
        return start;
    }

    public String countAndSay(String num) {
        char current = num.charAt(0);
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1, end = num.length(); i < end; i++) {
            char c = num.charAt(i);
            if (c == current)
                count++;
            else {
                sb.append(count);
                sb.append(current);
                current = c;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(current);
        return sb.toString();
    }
}
