package Arrays;

public class LinearSearchInSortedArray {

    public static void main(String[] args) {

        int[] arr = { 5, 6, 7, 8, 9, 10 };
        int n = arr.length;

        int key = 10;

        int position = findElement(arr, n, key);

        if (position == -1) {
            System.out.println("Element not found.");
        }
        else {
            System.out.println("Element found at position: " + (position + 1));
        }
    }

    public static int findElement(int[] arr, int n, int key) {

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }
}