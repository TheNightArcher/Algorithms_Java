import java.util.Scanner;

public class Generate_Vector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt((scanner.nextLine()));

        Integer[] vector = new Integer[input];

        int index = 0;

        fillVector(vector, index);
    }

    private static void fillVector(Integer[] vector, int index) {

        if (index > vector.length - 1) {
            print(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;

            fillVector(vector, index + 1);
        }
    }

    private static void print(Integer[] vector) {
        for (var result : vector) {
            System.out.print(result);
        }
        System.out.println();
    }
}
