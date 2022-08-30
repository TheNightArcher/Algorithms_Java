package SortAlgorithms.Advanced;

public class QuickSort {
    public static void main(String[] args) {

//        int[] arr = new int[]{2, 7, 5, 3, 10};
        int[] arr = new int[]{5, 4, 3, 2, 1};

        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lower, int high) {
        if (lower < high) {
            int current = partition(arr, lower, high);

            //Before partition
            quickSort(arr, lower, current - 1);

            //After partition
            quickSort(arr, current + 1, high);
        }
    }

    private static int partition(int[] arr, int lower, int high) {
        int pivot = arr[high];
        int i = (lower - 1);

        for (int j = lower; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
