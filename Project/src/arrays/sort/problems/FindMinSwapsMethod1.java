package arrays.sort.problems;

/*
*  A abordagem utilizada para contar a quantidade de mudanças necessárias para ordenar um array binário, baseia-se
*  na lógica de armazenar a quantidade de zeros existentes após uma determinada posição. Dessa forma, podemos iniciar
*  um array, para marcar a quantidade de zeros que precede uma determinada posição, e, como cada número 1 vai precisar
*  realizar a troca com cada um dos zeros, podemos apenas considerar que o número de trocas necessárias será a soma
*  de todos os zeros existentes após um número 1.
*
*   Complexidade de tempo: O(n) - Não há loopings aninhados, itera apenas duas vezes pelos arrays.
*   Complexidade de espaço: O(n) - Necessita criar outro array de mesmo tamanho.
* */

public class FindMinSwapsMethod1 {

    public static void main(String[] args) {

        int[] array = { 0, 0, 1, 0, 1, 0, 1, 1 };

        int quantity = findMinSwaps(array);

        System.out.println(quantity);
    }

    public static int findMinSwaps(int[] array) {

        int size = array.length;
        int[] noOfZeroes = new int[size];
        int count = 0;

        // Como não existe nenhum número após o último, precisamos ou adicionar 1, caso ele seja 0, ou manter como 0,
        // caso ele seja 1 e não necessite de nenhuma troca.
        noOfZeroes[size - 1] = 1 - array[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            // Recebe o valor da última posição do array. Caso ela seja 1, significa não haver nenhum zero após ela, e
            // caso seja 0, significa haver um zero, que é o próprio valor. Dessa forma, estamos armazenando a quantidade
            // de zeros que existe a direita.
            noOfZeroes[i] = noOfZeroes[i + 1];

            // Caso o valor no array original seja zero, incrementamos um, para marcar que há um zero à direita de tal
            // elemento. Implementar da forma "A posição atual recebe a posterior noOfZeroes[i + 1]" faz com que seja
            // acumulado para cada posição a quantidade de zeros que há depois dela.
            if (array[i] == 0) {
                noOfZeroes[i]++;
            }
        }

        for (int i = 0; i < size; i++) {

            // Caso o valor no array original seja 1, ele recebe a quantidade de zeros que existe a direita daquela
            // posição, e acumula em um contador.
            if (array[i] == 1) {
                count += noOfZeroes[i];
            }
        }

        return count;
    }
}