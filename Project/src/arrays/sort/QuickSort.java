package arrays.sort;

/*
*  O QuickSort é um algoritmo de ordenação baseado no paradigma "Dividir e Conquistar" que seleciona um
*  elemento como pivô e particiona o array fornecido em torno dele, colocando o pivô na sua posição correta
*  no array ordenado.
*
*  Vantagens
*   - Por ser um algoritmo do tipo "Dividir para conquistar", diminui a complexidade do problema, facilitando
*   o entendimento.
*   - É eficiênte para grandes conjuntos de dados.
*   - Precisa de apenas uma pequena quantidade de memória para funcionar.
*
*  Desvantagens
*   - Possui uma complexidade de tempo de O(n²), nos casos que o pivô é escolhido de maneira inadequada.
*   - Não é uma boa escolha para pequenos conjuntos de dados.
*
*   Complexidade de tempo: Melhor caso - O(n * log(n))
*                          Pior caso - O(n²)
*
*   Complexidade de espaço: Melhor caso - O(1) - Se não for considerado o espaço da pilha recursiva
*                           Pior caso - O(N) - Se for considerado o espaço da pilha recursiva.
* */

public class QuickSort {

    public static void main(String[] args) {

        int[] array = { 10, 7, 8, 9, 1, 5 };
        int size = array.length;

        System.out.println("Unsorted array:");
        printArray(array);

        quickSort(array, 0, size - 1);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void quickSort(int[] array, int start, int end) {

        // Verifica se há mais de um elemento no array.
        if (end > start) {

            int pivot = partition(array, start, end); // Recebe o índice do pivot, já na posição correta.

            // Após receber o índice do pivot, sabemos que todos os elementos a esquerda são menores do que o pivot
            // e todos os elementos a direita são maiores do que ele, porém, não estão ordenados. Então, temos certeza
            // de que o pivot está na posição correta, porém precisamos ordenar as outras duas partes, que seria o lado
            // esquerdo e direito do pivot.
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {

        int pivot = array[end]; // Pivot é estabelecido fixo como último elemento.

        // Mantém o índice do próximo elemento a ser trocado no array, e o próximo índice a ser inserido
        // o pivot, no final da execução do processo de troca.
        int i = start;

        // Repete o looping até o último elemento, ignorando o pivot
        for (int j = start; j < end; j++) {
            // Como a variável i é definida como o ínicio do array, sempre que encontramos um valor que seja menor do
            // que o pivot, trocamos ele com j, e enviamos para o ínicio do array, para a parte dos elementos que serão
            // menores do que o pivot.
            if (array[j] < pivot) {
                swap(array, i, j); // Troca o elemento menor, pelo elemento na posição j que é menor do que o pivot
                i++;
            }
        }

        swap(array, i, end); // Coloca o pivot na posição correta

        // Retorna o índice do último pivot, o que será comparado para definir as outras duas metades do array
        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}