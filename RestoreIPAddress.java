public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        int[] parts = new int[4];
        restoreHelper(s, 0, parts, 0, results);
        return results;
    }

    private void restoreHelper(String s, int index, int[] parts, int pidx, ArrayList<String> results) {
        if (index == s.length() && pidx == parts.length) {
            results.add(String.format("%d.%d.%d.%d", parts[0], parts[1], parts[2], parts[3]));
            return;
        }
        else if (index == s.length() || pidx == parts.length)
            return;
        if (s.charAt(index) == '0') {
            parts[pidx] = 0;
            restoreHelper(s, index + 1, parts, pidx + 1, results);
        }
        else {
            int num = 0;
            while (index < s.length()) {
                num = num * 10 + (s.charAt(index) - '0');
                if (num <= 255) {
                    parts[pidx] = num;
                    restoreHelper(s, index + 1, parts, pidx + 1, results);
                }
                else {
                    break;
                }
                index++;
            }
        }
    }
}
