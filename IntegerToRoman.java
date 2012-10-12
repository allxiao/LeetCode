public class Solution {
    static final char[][] table = {
        {'I', 'V', 'X'},
        {'X', 'L', 'C'},
        {'C', 'D', 'M'},
        {'M', '-', '-'},
    };
    
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        intToRoman(num, 0, sb);
        return sb.toString();
    }

    private void intToRoman(int num, int idx, StringBuffer sb) {
        if (num <= 0)
            return;
        if (num >= 10)
            intToRoman(num / 10, idx + 1, sb);
        int digit = num % 10;
        if (digit == 9) {
            sb.append(table[idx][0]);
            sb.append(table[idx][2]);
        }
        else if (digit == 4) {
            sb.append(table[idx][0]);
            sb.append(table[idx][1]);
        }
        else {
            if (digit >= 5) {
                sb.append(table[idx][1]);
                digit -= 5;
            }
            for (int i = 0; i < digit; i++)
                sb.append(table[idx][0]);
        }
    }
}
