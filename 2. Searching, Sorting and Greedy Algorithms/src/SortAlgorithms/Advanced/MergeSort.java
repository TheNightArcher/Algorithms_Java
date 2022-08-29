package SortAlgorithms.Advanced;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(input);

        StringBuilder stringBuilder = new StringBuilder();

        for (int j : input) {
            stringBuilder.append(j).append(" ");
        }

        System.out.println(stringBuilder);
    }

    private static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;

        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        if (mid < 0 || mid >= arr.length || arr[mid] < arr[mid + 1]) {
            return;
        }

        int left = begin;
        int right = mid + 1;

        int[] helper = new int[arr.length];

        System.arraycopy(arr, 0, helper, 0, arr.length);

        for (int i = begin; i <= end; i++) {
            if (left > mid) {
                arr[i] = helper[right++];
            } else if (right > end) {
                arr[i] = helper[left++];
            } else if (helper[left] < helper[right]) {
                arr[i] = helper[left++];
            } else {
                arr[i] = helper[right++];
            }
        }
    }
}
