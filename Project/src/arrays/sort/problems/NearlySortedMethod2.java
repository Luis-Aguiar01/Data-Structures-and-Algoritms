package arrays.sort.problems;

/*
*  Essa solução é melhor em termos de desemprenho do que a última, pois se limita a comparar a quantidade de posições
*  em que o array está desordenado, no caso desse código, apenas no máximo 3 posições. Isso evita ter que fazer
*  comparações em arrays muito grandes, economizando tempo de execução.
*
*  Complexidade de tempo: O(n*k) - A quantidade de vezes de iteração do looping depende do valor de distanciamento do
*  elemento para a sua posição correta.
*  Complexidade de espaço: O(1) - Não requere espaço adicional.
* */


public class NearlySortedMethod2 {

    public static void main(String[] args) {

        int[] array = { 2, 6, 3, 12, 56, 8 };
        int k = 3;

        System.out.println("Nearly sorted array:");
        printArray(array);

        sortNearlySortedArray(array, k);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void sortNearlySortedArray(int[] array, int k) {

        int key, j;
        int size = array.length;

        for (int i = 1; i < size; i++) {
             key = array[i];
             j = i - 1;

             // A função max tem dois argumentos, e retorna o maior dos dois. Como esse se trata de um array quase
             // ordenado, e que os seus elementos estão distantes k posições da sua posição correta, não precisamos fazer
             // mais do que k verificações. Nesse caso, a expressão max(0, i - k), vai retornar 0 para qualquer valor
             // negativo, e o próprio número da expressão, caso não seja negativo. Para o segundo elemento do array, por
             // exemplo, só precisamos fazer uma comparação com o seu antecessor. No caso do quarto, (j = 2; i = 3; k = 3)
             // max(0, 0), só precisamos fazer 3 comparações, que é de j = 2 até j >= 0 (j--)
             while (j >= Math.max(0, i - k) && array[j] > key) {
                 array[j + 1] = array[j];
                 j--;
             }

             array[j + 1] = key; // insere o valor chave na sua posição correta.
        }
    }
}