package arrays.sort;

/*
*  A ordenação por mesclagem é definida como um algoritmo de ordenação que funciona dividindo um array em sub-arrays menores
*  ordenando cada sub-array e, em seguida, mesclando os sub-arrays ordenados de volta para formar o array final ordenado.
*
*  Vantagens:
*   - Bom desempenho com grandes quantidades de dados.
*
*  Desvantagens
*   - Nem sempre é ideal para conjunto de dados pequenos
*   - Difícil de entender.
*
*   Complexidade de tempo: O(n*log(n))
*   Complexidade de espaço: O(n)
* */

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int size = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr);

        mergeSort(arr, 0, size - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void mergeSort(int[] array, int start, int end) {

        if (end > start) {

            int middle = (start + end) / 2;

            // A primeira execução de sort, ordena o array do lado esquerdo, parando a sua recursão quando atinge o caso
            // base, que é quando o array possui apenas um elemento, e um array de um único elemento já está naturalmente
            // ordenado.
            mergeSort(array, start, middle);

            // A segunda execução de sort, ordena o lado direito do array, quando ela chama novamente a si mesmo,
            // a função "sort(arr, left, middle)" é quem faz a ordenação do array do lado direito, sendo que, ao
            // atingir o caso base, retorna para a próxima execução, que seria a função merge, para mesclar os dois
            // arrays.
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {

        // Define o tamanho de armazenamento para os dois arrays.
        int sizeLeft = (middle - start + 1);
        int sizeRight = (end - middle);

        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        // Preenche o array left com os valores a serem comparados do array.
        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = array[start + i];
        }

        // Preenche o array right com os valores a serem comparados do array.
        for (int j = 0; j < sizeRight; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0; // Duas variáveis para verificar os elementos dos dois arrays (left e right)

        int k = start;

        // Funciona como se estivéssemos ordenando cartas em um baralho, com duas outras partes dele. Primeiro, retiramos
        // uma carta de cima dos dois montes, e comparamos para ver qual é a menor delas. Quando encontramos a menor,
        // tiramos ela do monte, e adicionamos ao baralho ordenado. Sendo assim, continuamos retirando até finalizar um
        // dos baralhos.
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Adiciona os valores restantes no array da esquerda ao array original.
        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Adiciona os valores restantes no array da direita ao array original.
        while (j < sizeRight) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}