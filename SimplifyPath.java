import java.util.ArrayList;

public class Solution {
    public String simplifyPath(String path) {
        int start = 1;
        ArrayList<String> parts = new ArrayList<String>();
        while (start < path.length()) {
            if (path.charAt(start) == '/') {
                start++;
                continue;
            }
            int pos = path.indexOf('/', start);
            if (pos < 0) {
                pos = path.length();
            }
            String part = path.substring(start, pos);
            start = pos;
            if (part.equals("."))
                continue;
            else if (part.equals("..")) {
                if (parts.size() > 0)
                    parts.remove(parts.size() - 1);
            }
            else
                parts.add(part);
        }
        if (parts.size() == 0)
            return "/";
        StringBuffer sb = new StringBuffer();
        for (String part : parts) {
            sb.append('/');
            sb.append(part);
        }
        return sb.toString();
    }
}
