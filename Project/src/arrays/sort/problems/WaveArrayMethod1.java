package arrays.sort.problems;

/*
*   Dado um array de inteiro não ordenado, ordene-o em um "array em forma de onda". Um array
*   arr[0..n-1] está ordenado em forma de onda se:
*
*       arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= ...
*
*   Complexidade de tempo: O(n log(n))
*   Complexidade de espaço: O(1)
* */

import java.util.Arrays;

public class WaveArrayMethod1 {

    public static void main(String[] args) {

        int[] array = { 10, 90, 49, 2, 1, 5, 23 };

        Arrays.sort(array);

        System.out.println("Array ordenado:");
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

        // O índice avança a cada 2, para inverter dois pares de números que estão na ordem crescente
        for (int i = 0; i < size - 1; i += 2) {
            swap(array, i, i + 1);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}