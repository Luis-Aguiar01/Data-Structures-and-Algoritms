package arrays;

/*
*   Se trata de uma abordagem simples, mas extremamente custosa em termos de tempo.
*   Utiliza dois loops para percorrer o array, sendo que para cada elemento
*   terá que ser percorrido o array do início ao fim.
*   Complexidade de tempo: O(n²)
*   Complexidade de espaço: O(1) - Não cria espaço adicional
*/

public class EquilibriumIndexMethod1 {

    public static void main(String[] args) {
        int[] arr = {  -7, 1, 5, 2, -4, 3, 0 };
        int size = arr.length;

        int result = equilibrium(arr, size);
        System.out.println(result);
    }

    public static int equilibrium(int[] arr, int size) {

        int leftSum;
        int rightSum;

        // Define o index do elemento que será analisado
        for (int i = 0; i < size; i++) {
            leftSum = 0;

            // Soma todos os elementos a esquerda, até ser menor do que o índice do elemento
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            rightSum = 0;

            // Soma todos os elementos a esquerda, até ser diferente do comprimento total.
            for (int k = i + 1; k < size; k++) {
                rightSum += arr[k];
            }

            // Caso a soma das duas extremidades sejam iguais em relação ao elemento do index, o index é retornado.
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}