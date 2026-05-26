package driver;

import math.Fibonacci;

import java.util.Scanner;

public class DriverFunction {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value of n to find the nth Fibonacci number: ");
            int n = sc.nextInt();
            System.out.println("The " + n + "th Fibonacci number is: " + Fibonacci.nthFibonacci(n));
        }
    }
}

