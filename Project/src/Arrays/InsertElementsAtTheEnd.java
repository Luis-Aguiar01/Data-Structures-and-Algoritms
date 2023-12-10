package Arrays;

public class InsertElementsAtTheEnd {

    // Complexidade geral do código = O(n)

    public static void main(String[] args) {

        int[] arr = new int[20];

        // Inicialização das posições do array, complexidade O(1)
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;

        int capacity = 20;
        int n = 6;
        int key = 26;

        System.out.println("Before Insertion: ");

        // Imprime todos os valores do array. Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        n = insertSorted(arr, n, key, capacity);

        System.out.println("\nAfter insertion: ");

        // Imprime todos os valores do array. Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int insertSorted(int[] arr, int n, int key, int capacity) {

        // Caso o array já tenha atingido sua capacidade máxima (número de elementos), o próprio n é retornado. Complexidade O(1) - Constante
        if (n >= capacity) {
            return n;
        }

        arr[n] = key; // Complexidade O(1) - Constante

        return (n + 1);
    }
}