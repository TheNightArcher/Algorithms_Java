package SortAlgorithms.Advanced;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort {
    public static int[] counts;

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 7, 5, 3, 40, 10};

        Integer max = Collections.max(Arrays.asList(2, 2, 7, 5, 3, 40, 10));

        counts = new int[max + 1];

        sort(arr);

        for (int index = 0; index < counts.length; index++) {
            if (counts[index] != 0) {
                for (int i = 0; i < counts[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }

    private static void sort(int[] arr) {
        for (int count : arr) {
            counts[count]++;
        }
    }
}
