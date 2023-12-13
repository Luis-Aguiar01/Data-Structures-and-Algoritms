package arrays.sort;

/*
*  O algoritmo de ordenação por bolhas, funciona fazendo com que, a cada iteração, o maior elemento dentro do array
*  vai estar na última posição, sendo que está já não precisa mais ser verificada.
*
*  Complexidade de tempo: O(n²) - Utiliza loopings aninhados.
*  Complexidade de espaço: O(1) - Não requer mais espaço.
*
*  Vantagens
*   - Fácil de entender e de aplicar
*   - Funciona bem com quantidade de dados pequenas.
*
*  Desvantagens
*   - Muito custoso em termos de tempo de execução em um grande conjunto de dados.
*/

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int size = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr, size);

        bubbleSort(arr, size);

        System.out.println("Sorted array:");
        printArray(arr, size);
    }

    public static void printArray(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void bubbleSort(int[] arr, int size) {

        for (int i = 0; i < size - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < size - i - 1; j ++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }
}