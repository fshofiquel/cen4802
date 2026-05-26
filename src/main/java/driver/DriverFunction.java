package driver;

import math.Fibonacci;

import java.util.Scanner;

public class DriverFunction {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            System.out.flush();
            int n = sc.nextInt();
            int result = Fibonacci.nthFibonacci(n);
            System.out.printf("%nResult: Fibonacci(%d) = %d%n", n, result);
        }
    }
}

