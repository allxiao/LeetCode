public class Solution {
    public String convert(String s, int rows) {
        int slen = s.length();
        if (slen == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        int group = rows + rows - 2;
        int groupcount = (slen - 1) / group + 1;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < groupcount; i++) {
                int startidx = i * group;
                if (j == 0 || j == rows - 1) {
                    int idx = startidx + j;
                    if (idx < slen)
                        sb.append(s.charAt(idx));
                }
                else {
                    int idx1 = startidx + j;
                    int idx2 = startidx + (group - j);
                    if (idx1 < slen)
                        sb.append(s.charAt(idx1));
                    if (idx2 < slen)
                        sb.append(s.charAt(idx2));
                }
            }
        }
        return sb.toString();
    }
}
