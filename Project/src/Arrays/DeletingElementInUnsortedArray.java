package Arrays;

public class DeletingElementInUnsortedArray {

    public static void main(String[] args) {

        int[] arr = { 10, 50, 30, 40, 20 };

        int n = arr.length;
        int key = 30;

        System.out.println("Array before deletion");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        n = deleteElement(arr, n, key);

        System.out.println("\n\nArray after deletion");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
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

    public static int deleteElement(int[] arr, int n, int key) {

        int pos = findElement(arr, n, key);

        if (pos == -1) {
            System.out.println("element not found.");
            return n;
        }

        // Complexidade O(n)
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return (n - 1);
    }
}
