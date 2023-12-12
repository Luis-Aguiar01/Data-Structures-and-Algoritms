package arrays.insert;

public class InsertElementsInASortedArray {

    public static void main(String[] args) {

        int[] arr = new int[20];

        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;

        int capacity = arr.length;
        int n = 6;
        int key = 26;

        System.out.print("\nBefore Insertion: ");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        n = insertSorted(arr, n, key, capacity);

        System.out.print("\nAfter Insertion: ");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int insertSorted(int[] arr, int n, int key, int capacity) {

        // Complexidade O(1)
        if (n >= capacity) {
            return n;
        }

        int i;

        // Percorre o array a partir do índice do último elemento. Cada elemento é reescrito para uma casa posterior. O looping termina quando o array atinge o seu final (de trás para frente) ou quando um valor no índice i do array é menor ou igual a chave. Complexidade O(n)
        for (i = n - 1; (i >= 0 && arr[i] > key); i--) {
            arr[i + 1] = arr[i];
        }

        arr[i + 1] = key;

        return (n + 1);
    }
}