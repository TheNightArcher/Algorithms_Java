package SortAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {

        int[] beforeSortResult = new int[]{2, 7, 5, 3, 10};

        bubbleSort(beforeSortResult);
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int currentElement = i + 1; currentElement < arr.length - 1; currentElement++) {

                if (arr[i] > arr[currentElement]) {
                    swap(arr, i, currentElement);
                }
            }
        }
        print(arr);
    }

    private static void print(int[] arr) {
        for (var element : arr) {
            System.out.print(element + " ");
        }
    }

    private static void swap(int[] arr, int i, int currentElement) {
        int temp = arr[currentElement];
        arr[currentElement] = arr[i];
        arr[i] = temp;
    }
}