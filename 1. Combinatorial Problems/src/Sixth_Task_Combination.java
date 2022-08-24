import java.util.Scanner;

public class Sixth_Task_Combination {
    public static String[] input;
    public static String[] combinationArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        combinationArray = new String[k];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index >= combinationArray.length) {
            print(combinationArray);
            return;
        }

        for (int i = start; i < input.length; i++) {
            combinationArray[index] = input[i];
            combinations(index + 1, i);
        }
    }

    private static void print(String[] input) {
        System.out.println(String.join(" ", input).trim());
    }
}