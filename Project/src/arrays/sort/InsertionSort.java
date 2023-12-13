package arrays.sort;

/*
*  No algoritmo de ordenação por inserção, dois elementos de um array são comparados, um valor chave e o seu predecessor
*  caso o valor predecessor seja maior do que o valor chave, os dois são trocados, sendo que a cada troca é verificado todos
*  os valores predecessores da troca, até encontrar uma posição que o predecessor não seja maior do que o elemento chave.
*
*  Complexidade de tempo: O(n²)
*  Complexidade de espaço: O(1)
*
*  Vantagens:
*   - Fácil de implementar e entender
*   - Funciona bem para ordenação de dados pequenos
*
*  Desvantagens
*   - Ineficiente para ordenar grandes quantidades de dados
*/

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

            int key = arr[i]; // Recebe o valor do array no índice
            int j = (i - 1); // Recebe o valor do predecessor do índice do array

            while (j >= 0 && arr[j] > key) {
                // Caso o array na posição posterior seja maior do que a posição atual (key)
                // os seus valores são trocados.
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key; // Completa a troca adicionando o valor atual (key) na posição correta
        }
    }
}