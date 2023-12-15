package arrays.sort.problems;

/*
 *  Essa solução não representa os melhores casos em relação ao desempenho, pois cada valor do array é verificado em todos
 *  os outros valores da sua esquerda, quando, na verdade, seria necessário verificar até no máximo a quantidade de
 *  posições que os elementos estão fora de suas posições.
 *
 *  Complexidade de tempo: O(n*k) - A quantidade de vezes de iteração do looping depende do valor de distanciamento do
 *  elemento para a sua posição correta.
 *  Complexidade de espaço: O(1) - Não requere espaço adicional.
 * */

public class NearlySortedMethod1 {

    public static void main(String[] args) {

        int[] array = { 6, 5, 3, 2, 8, 10, 9 };

        System.out.println("Unsorted array:");
        printArray(array);

        insertionSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void insertionSort(int[] array) {

        int key, j;
        int size = array.length;

        // A partir de um valor chave, conseguimos ordenar o array comparando o valor chave com os seus antecessores,
        // verificando se eles são maiores ou não do que o valor chave. Caso um valor posterior seja maior do que um valor
        // chave, é necessário realizar a troca entre os dois, e isso é repetido até o fim do array (de trás para a frente).
        for (int i = 1; i < size; i++) {
            key = array[i]; // Elemento a ser inserido na posição correta.
            j = i - 1; // Recebe o índice do elemento anterior a chave.

            // Itera percorrendo o array de trás para frente, comparando se o elemento anterior é ou não maior do que a
            // chave
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // Coloca o elemento maior do que a chave na sua posição
                j--;
            }

            array[j + 1] = key; // Coloca a chave na posição onde ela é maior do que todos os seus antecessores.
        }
    }
}