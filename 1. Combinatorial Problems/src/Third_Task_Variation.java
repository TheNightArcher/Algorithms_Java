import java.util.Scanner;

public class Third_Task_Variation {
    public static String[] input;
    public static String[] variationsArray;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        variationsArray = new String[k];
        used = new boolean[input.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index >= variationsArray.length) {
            print(variationsArray);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variationsArray[index] = input[i];
                variations(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] input) {
        System.out.println(String.join(" ", input).trim());
    }
}
