import java.util.Arrays;
import java.util.Scanner;

public class Array_Sum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = 0;

        long sum = sumNumbers(input, index);

        System.out.println(sum);
    }

    private static long sumNumbers(int[] input, int index) {
        if (index >= input.length) {
            return 0;
        }

        return input[index] + sumNumbers(input, index + 1);
    }
}
