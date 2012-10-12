public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length())
            return multiply(num2, num1);
        char[] result = new char[num1.length() + num2.length()];
        for (int j = 0, je = num2.length(); j < je; j++) {
            int factor = num2.charAt(j) - '0';
            if (factor == 0)
                continue;
            for (int i = 0, ie = num1.length(); i < ie; i++) {
                int base = num1.charAt(i) - '0';
                add(result, i + j + 1, base * factor);
            }
        }

        int count = 0;
        while (count < result.length && result[count] == 0)
            count++;
        for (int i = count; i < result.length; i++) {
            result[i] += '0';
        }

        if (count > 0) {
            if (count == result.length)
                return "0";
            return new String(result, count, result.length - count);
        }
        else
            return new String(result);
    }

    private void add(char[] result, int pos, int number) {
        while (number > 0) {
            number += result[pos];
            result[pos] = (char)(number % 10);
            number /= 10;
            pos--;
        }
    }
}
