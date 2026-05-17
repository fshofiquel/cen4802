package math;

public class Fibonacci {
    public static int nthFibonacci(int n) {

        // base case
        if (n <= 1) {
            return n;
        }
        // sum of the two preceding
        // Fibonacci numbers
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
}
