import java.util.HashSet;
import java.util.Scanner;

public class Second_Task_Permutation {
    public static String[] input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index == input.length) {
            print(input);
            return;
        }

        HashSet<String> swapped = new HashSet<>();
        swapped.add(input[index]);

        permute(index + 1);
        for (int i = index + 1; i < input.length; i++) {
            if (!swapped.contains(input[i])) {
                swap(input, index, i);
                permute(index + 1);
                swapped.add(input[i]);
            }
        }
    }

        private static void swap(String[] input, int first, int second) {
            String temp = input[first];
            input[first] = input[second];
            input[second] = temp;
        }

    private static void print(String[] input) {
        System.out.println(String.join(" ", input));
    }
}
