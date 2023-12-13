package arrays.sort;

/*
*  O algoritmo de ordenação heapsort, funciona transformando um array em uma árvore binária, sendo que cada nó pai deve
*  possuir um valor maior do que os seus filhos, e o nó raiz, deve possuir o maior valor (max-heap). Os valores do array são
*  distribuídos em uma árvore da esquerda para direita, sendo o primeiro elemento o nó raiz, e os dois próximos os seus
*  filhos. Dessa forma, os elementos continuam sendo divididos para cada nó.
*
*   Vantagens
*    - Tem um bom desempenho com grandes quantidades de dados
*    - Não necessita de espaço adicional
*    - Mais fácil de entender do que os algoritmos de ordenação mais eficientes
*
*   Desvantagens
*    - Não é eficiente com tipos de dados complexos
*    - Não preserva a ordem relativa dos elementos
*
*   Complexidade de tempo: O(n*log(n))
*   Complexidade de espaço: O(1) - É um método in-place, ou seja, ordena no próprio array, sem precisar de espaço adicional
*/


public class HeapSort {

    public static void main(String[] args) {

        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int size = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr);

        heapSort(arr);

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

    public static void heapSort(int[] arr) {

        int size = arr.length;

        // Inicializar o contador com essa expressão faz com que ele inicialize no índice do último nó, evitando ter que
        // verificar valores folha, que não possuem nenhum filho, ou seja, não precisam ser ordenados.
        for (int i = ( size / 2 - 1 ); i >= 0; i--) {
            heapify(arr, size, i);
        }

        // Inicializa o índice no último elemento, decrementando do último para o primeiro, sendo que os últimos indices
        // recebem o primeiro valor do nó raiz, que possui o maior valor. Dessa forma, a cada iteração, o maior valor que
        // estava no nó folha, vai para o final do array.
        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i]; // Passa o maior valor para um dos últimos nós
            arr[i] = temp;
            
            heapify(arr, i, 0); // Reordena o nó raiz, para que ele possua o maior valor.
        }
    }

    public static void heapify(int[] arr, int size, int i) {

        int largest = i; // Se refere ao valor do nó pai
        int left = (2 * i) + 1; // Se refere ao valor do filho esquerdo
        int right = (2 * i) + 2; // Se refere ao valor do filho direito

        // Caso o valor do filho esquerdo seja maior do que o valor do nó pai, o valor maior é atualizado.
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // Caso o valor do filho direito seja maior do que o maior valor atual, então o maior valor é atualizado.
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // Caso o maior valor tenha trocado, significa que o nó pai não tinha o maior valor em relação aos seus filhos
        // sendo assim, é necessário realizar a troca para o nó pai ter o maior valor.
        // Outra chamada recursiva é feita, para garantir que o nó pai tenha o maior valor em relação aos seus filhos
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, size, largest);
        }
    }
}