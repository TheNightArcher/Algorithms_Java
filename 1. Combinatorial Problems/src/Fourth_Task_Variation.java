import java.util.Scanner;

public class Fourth_Task_Variation {
    public static String[] input;
    public static String[] variationsArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        variationsArray = new String[k];

        variations(0);
    }

    private static void variations(int index) {
        if (index >= variationsArray.length) {
            print(variationsArray);
            return;
        }

        for (String s : input) {
            variationsArray[index] = s;
            variations(index + 1);
        }
    }

    private static void print(String[] input) {
        System.out.println(String.join(" ", input).trim());
    }
}

