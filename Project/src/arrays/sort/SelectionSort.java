package arrays.sort;

/*
*  A ordenação por seleção é um algoritmo que percorre todo o array, encontra o menor elemento
*  e o coloca no início. Esse processo é repetido para os elementos restantes até que o array esteja ordenado.
*
*  Complexidade de tempo: O(n²) - Possui loops aninhados.
*  Complexidade de espaço: O(1) - Não necessita de uma maior alocação da memória para funcionar.
*
*  Vantagens
*   - Fácil de implementar.
*   - Fácil de entender.
*
*  Desvantagens
*   - Muito custoso para arrays grandes.
*   - Demora até que a ordenação seja concluída em arrays grandes.
*
*/


public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = { 64,25,12,22,11 };

        System.out.println("Unsorted array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        int size = arr.length;

        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    public static void selectionSort(int[] arr) {

        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {

            int smallestNumberIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[smallestNumberIndex]) {
                    smallestNumberIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[smallestNumberIndex];
            arr[smallestNumberIndex] = temp;
        }
    }
}