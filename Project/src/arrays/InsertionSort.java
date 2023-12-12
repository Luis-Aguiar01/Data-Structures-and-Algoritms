package arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = { 12, 11, 13, 5, 6 };

        System.out.println("Unsorted array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {

        int size = arr.length;

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void insertionSort(int[] arr) {

        int size = arr.length;

        for (int i = 1; i < size; i++) {

            int key = arr[i];
            int j = (i - 1);

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}