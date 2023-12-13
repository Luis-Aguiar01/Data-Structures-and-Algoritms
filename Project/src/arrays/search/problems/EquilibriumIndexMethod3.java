package arrays.search.problems;

/*
*  No seguinte código, a abordagem utilizada para descobrir o índice de equilíbrio, funciona somando todos os elementos do array
*  e armazenando essa soma em outros dois arrays, um que recebe a soma dos elementos do array original, do começo ao fim,
*  sendo que cada posição representa a soma das posições anteriores, e outro array, que faz o mesmo, só que do final para
*  o começo. Sendo assim, cada posição nos dois arrays vão ter o acumulo das posições anteriores. Dessa forma, se for realizada
*  a comparação com os valores, caso eles sejam iguais, significa que os valores da esquerda somados são iguais aos da direita
*  somados, temos aí o índice de equilíbrio.
*
*  Complexidade de tempo: O(n)
*  Complexidade de espaço: O(n)
*/

public class EquilibriumIndexMethod3 {

    public static void main(String[] args) {

        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int size = arr.length;

        int result = equilibrium(arr, size);
    }

    public static int equilibrium(int[] arr, int size) {

        if (size == 1) {
            return 0;
        }

        int[] front = new int[size];
        int[] back = new int[size];

        // O array front, representa em cada uma das suas posições, o valor do array original naquela posição
        // somado com os elementos das posições anteriores. Faz a soma da parte direita. Cada elemento é a soma
        // de todos os elementos anteriores
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                front[i] = front[i - 1] + arr[i];
            }
            else {
                front[i] = arr[i];
            }
        }

        // O array back, representa em cada uma das suas posições, o valor do array original naquela posição
        // somado com os elementos das posições anteriores. Faz a soma da parte esquerda. Cada elemento é a soma
        // de todos os elementos anteriores
        for (int i = size - 1; i > 0; i--) {
            if (i <= size - 2) {
                back[i] = back[i + 1] + arr[i];
            }
            else {
                back[i] = arr[i];
            }
        }

        // Caso os valores dos dois arrays em um mesmo índice sejam iguais, significa que naquela posição
        // todos os números somados da esquerda são iguais a todos os números somados a direita.
        for (int i = 0; i < size; i++) {
            if (front[i] == back[i]) {
                return i;
            }
        }

        return -1;
    }
}