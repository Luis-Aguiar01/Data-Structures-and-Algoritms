package arrays.sort.problems;

import java.util.Arrays;

/*
*   Nessa abordagem, considerando os índices de um array ordenado, em ordem crescente, todos os índices pares serão
*   menores do que os seus índices ímpares posteriores, dessa forma, apenas precisamos iterar pelos índices pares e
*   trocar o valor com o seu ímpar posterior.
*
*  Complexidade de tempo: O(n)
*  Complexidade de espaço: O(1) - Não necessita de espaço adicional.
*
* */

public class WaveArrayMethod2 {

    public static void main(String[] args) {

        int[] array = { 10, 90, 49, 2, 1, 5, 23 };

        Arrays.sort(array);

        System.out.println("Sorted array:");
        printArray(array);

        sortInWave(array);

        System.out.println("Array in wave:");
        printArray(array);
    }

    public static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void sortInWave(int[] array) {

        int size = array.length;

        // Incrementa de dois em dois para obter todos os índices pares do array.
        for (int i = 0; i < size - 1; i += 2) {

            // Troca um elemento em um índice par com o seu elemento posterior ímpar, que em um array ordenado
            // sempre será maior que o valor par
            if (i < size - 1 && array[i + 1] > array[i]) {
                swap(array, i, i + 1);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}