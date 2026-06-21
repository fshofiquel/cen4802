package driver;
import math.Fibonacci;
import java.util.Scanner;
import java.time.LocalDate;

public class DriverFunction {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LocalDate myObj = LocalDate.now();

            System.out.print("Enter n: ");
            System.out.flush();
            int n = sc.nextInt();
            int result = Fibonacci.nthFibonacci(n);
            System.out.printf("%nResult: Fibonacci(%d) = %d%n", n, result);
            System.out.println("Execution completed successfully, the current date is " + myObj);
        }
    }
}

