package SearchAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int key = Integer.parseInt(scanner.nextLine());

        int begin = 0;
        int end = input.length;
        int result = search(input, key, begin, end);

        System.out.println(result);
    }

    private static int search(int[] arr, int key, int begin, int end) {
        while (end > begin) {
            int middle = (begin + end) / 2;
            if (arr[middle] > key) {
                end = middle - 1;
            } else if (arr[middle] < key) {
                end = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
