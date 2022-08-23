import java.util.Scanner;

public class Recursive_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        long result = getResult(input);

        System.out.println(result);
    }

    private static long getResult(int input) {
        if (1 >= input) {
            return 1;
        }
        return input * getResult(input - 1);
    }
}
