package arrays;

/*
*   O código abaixo representa uma melhor solução para encontrar o index de equilíbrio no array, em termos de desempenho.
*   Primeiro, todo o array é somado, e armazenado em uma variável 'sum'.
*   Após isso, a cada iteração do loop, 'sum' é decrementada no valor do array no índice atual, sendo esta a representação do lado direito
*   A variável 'leftSum' representa a soma do lado esquerdo, tendo o seu valor incrementado a cada iteração do loop
*   Se a variável 'leftSum' for igual a variável 'sum', significa que encontramos o índice de equilíbrio e podemos retorná-lo
*
*   Complexidade de tempo: O(n)
*   Complexidade de espaço: O(1)
*/

public class EquilibriumIndexMethod2 {

    public static void main(String[] args) {

        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int size = arr.length;

        int result = equilibrium(arr, size);
        System.out.println("First equilibrium index is " + result);
    }

    public static int equilibrium(int[] arr, int size) {

        int sum = 0;
        int leftSum = 0;

        // Recebe a soma de todos os elementos no array
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }

        // Diminui o total para cada elemento do array, enquanto acumula na variável 'leftSum' a soma dos indices atuais
        // Dessa forma, é possível ter a soma da parte esquerda e direita, sendo a direita decrementada do total.
        for (int i = 0; i < size; i++) {
            sum -= arr[i];

            if (leftSum == sum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}