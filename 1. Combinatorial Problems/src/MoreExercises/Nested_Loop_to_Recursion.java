package MoreExercises;

import java.util.Scanner;

public class Nested_Loop_to_Recursion {
    public static int[] output;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        output = new int[n];

        permute(0);
    }

    private static void permute(int index) {
        if (index == output.length) {
            print();
            return;
        }

        for (int i = 1; i <= n; i++) {
            output[index] = i;
            permute(index + 1);
        }
    }

    private static void print() {
        for (int j : output) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
