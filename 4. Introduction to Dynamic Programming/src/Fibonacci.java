import java.util.Scanner;

public class Fibonacci {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        dp = new long[input + 1];

        long result = fib(input);
        System.out.println(result);
    }

    private static long fib(int input) {
        if (input <= 2) {
            return 1;
        }

        if (dp[input] != 0) {
            return dp[input];
        }

        return dp[input] = fib(input - 1) + fib(input - 2);
    }
}
