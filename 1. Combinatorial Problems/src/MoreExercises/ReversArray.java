package MoreExercises;

import java.util.Scanner;

public class ReversArray {
    public static String[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        result = new String[input.length];
        reversInput(input, input.length - 1, 0);
    }

    private static void reversInput(String[] input, int index, int start) {
        if (index < 0) {
            print(result);
            return;
        }

        for (int i = start; i < input.length; i++) {

            result[i] = input[index];
        }
        reversInput(input, index - 1, start + 1);
    }

    private static void print(String[] input) {
        System.out.println(String.join(" ", input));
    }
}
