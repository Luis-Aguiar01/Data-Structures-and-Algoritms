package arrays.sort.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*  Este algoritmo utiliza o método de ordenação Quicksort para ordenar um array quase ordenado. Como sabemos quantas
*  posições no máximo cada está fora de sua posição, podemos usar um Quicksort que aproveite dessa situação, para não
*  realizar todas as verificações. Seguindo essa lógica, podemos definir tanto um limite inferior quanto um limite
*  superior para a comparação com o pivot, isso economiza tempo de execução e melhora o desempenho do algoritmo.
*
*   Complexidade de tempo: O(n * log(n))
*   Complexidade de espaço: O(log(n))
* */


public class NearlySortedMethod3 {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>(List.of(3, 3, 2, 1, 6, 4, 4, 5, 9, 7, 8, 11, 12));

        int k = 3;
        int size = array.size();

        System.out.println("Array before K sort:");
        System.out.println(array);

        kSorter(array, 0, size - 1, k);

        System.out.println("Array after K sort:");
        System.out.println(array);
    }

    public static void kSorter(ArrayList<Integer> array, int start, int end, int k) {
        if (end > start) {
            int pivotIndex = partition(array, start, end, k);
            kSorter(array, start, pivotIndex - 1, k);
            kSorter(array, pivotIndex + 1, end, k);
        }
    }

    public static int partition(ArrayList<Integer> array, int low, int high, int k) {

        int middle = (high + low) / 2; // Define a posição do pivot como o meio da lista.

        // As duas chamadas para Math.max e Math.min, define os dois limites do método partition, tanto o limite superior
        // quanto o limite inferior, respectivamente. Como sabemos que cada elemento está a no máximo k posições da sua
        // posição correta para a ordenação, não precisamos verificar todas as posições, apenas aquelas que estão dentro
        // do limite. Define o limite inferior.
        int start = Math.max(low, middle - k);

        // Define o limite superior. Como é possível que (middle + k) ultrapasse os limites do array, a utilização
        // do Math.min evita que isso aconteça, pois escolha o menor valor entre o fim da lista e o valor de limite
        // para a comparação superior.
        int end = Math.min(middle + k, high);

        int j = start; // Recebe a posição do índice que começa a incrementar para comparar com o pivot

        Collections.swap(array, end, middle);

        while (j < end) {
            if (array.get(j) < array.get(end)) {
                Collections.swap(array, j, start);
                start++;
            }
            j++;
        }

        Collections.swap(array, end, start); // Troca o pivot para a posição final na partição.

        return start; // Retorna a posição do pivot
    }
}