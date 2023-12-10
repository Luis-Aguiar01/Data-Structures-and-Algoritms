package Arrays;

public class InsertElementsAnyPosition {

    public static void main(String[] args) {

        int[] arr = new int[15];

        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 1;
        arr[3] = 8;
        arr[4] = 5;
        int n = 5; // Quantidade de elementos inicializados
        int x = 10; // Valor a ser adicionado
        int pos = 2; // Posição para ser adicionado

        System.out.println("Before Insertion: ");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        insertElement(arr, n, x, pos);
        n += 1;

        System.out.println("\n\nAfter Insertion: ");

        // Complexidade O(n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertElement(int[] arr, int n, int x, int pos) {

        // Inicializa o contador no índice do último elemento inserido no array, cada um dos elementos são passados a uma posição posterior, até passar o índice que se deseja inserir o elemento. Complexidade O(n)
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }

        arr[pos] = x; // Adiciona o elemento, depois que todos os outros foram redirecionados para uma posição a mais no array
    }
}