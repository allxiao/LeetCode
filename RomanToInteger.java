public class Solution {
    static final int[] table = new int[128];
    static {
        table['I'] = 1;
        table['V'] = 5;
        table['X'] = 10;
        table['L'] = 50;
        table['C'] = 100;
        table['D'] = 500;
        table['M'] = 1000;
    }
    
    public int romanToInt(String s) {
        int result = 0;
        int pos = 0;
        while (pos < s.length()) {
            char pchar = s.charAt(pos);
            if (pos < s.length() - 1) {
                char nchar = s.charAt(pos + 1);
                if (table[pchar] < table[nchar]) {
                    result += table[nchar] - table[pchar];
                    pos += 2;
                    continue;
                }
            }
            result += table[pchar];
            pos++;
        }

        return result;
    }
}
