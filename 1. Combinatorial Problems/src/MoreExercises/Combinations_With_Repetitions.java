package MoreExercises;

import java.util.Scanner;

public class Combinations_With_Repetitions {
    public static int[] numbers;
    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        k = Integer.parseInt(scanner.nextLine());

        numbers = new int[k];

        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index >= numbers.length) {
            print(numbers);
            return;
        }
        for (int i = start; i <= n; i++) {
            numbers[index] = i;
            combinations(index + 1, i);
        }
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
