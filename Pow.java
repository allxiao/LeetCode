public class Solution {
    public double pow(double x, int n) {
        if (n < 0)
            return 1.0 / pow(x, 1, -n);
        return pow(x, 1, n);
    }

    private double pow(double x, double y, int n) {
        if (n == 0)
            return y;
        if (n % 2 == 0)
            return pow(x * x, y, n / 2);
        else
            return pow(x * x, y * x, n / 2);
    }
}
