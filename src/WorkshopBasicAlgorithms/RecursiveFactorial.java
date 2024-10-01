package WorkshopBasicAlgorithms;

import java.util.Scanner;

public class RecursiveFactorial {
    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());
        System.out.print(factorial(n));
    }
}
