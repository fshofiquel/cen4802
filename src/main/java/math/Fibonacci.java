package math;

public class Fibonacci {
    private Fibonacci() {
        // Private constructor to prevent instantiation
    }

    /**
     * Recursively calculates the nth Fibonacci number.
     * The sequence begins with 0 and 1, where each subsequent
     * number is the sum of the two preceding numbers (0, 1, 1, 2, 3, 5, 8...).
     *
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the Fibonacci number at position n
     */

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

