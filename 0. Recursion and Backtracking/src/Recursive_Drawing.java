import java.util.Scanner;

public class Recursive_Drawing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        printFigure(input);

        System.out.println();
    }

    private static void printFigure(int input) {
        if (0 >= input) {
            return;
        }

        for (int i = input; i > 0; i--) {
            System.out.print("*");
        }
        System.out.println();

        printFigure(input - 1);

        for (int i = input; i > 0; i--) {
            System.out.print("#");
        }
        System.out.println();
    }
}
