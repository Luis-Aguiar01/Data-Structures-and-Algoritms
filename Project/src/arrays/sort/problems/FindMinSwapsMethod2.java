package arrays.sort.problems;

/*
*  Em relação à solução anterior, essa é mais otimizada em questão da memória, pois não precisa de um array auxiliar
*  para contar a quantidade de trocas que são necessárias. Nessa abordagem, começamos a iterar pelo array do fim para o
*  começo, sendo que cada zero encontrado é contado e acumulado em um contador de zeros. Ao encontrar um número "1", a
*  quantidade de vezes que ele deve ser trocado, é igual à quantidade de zeros encontrados até o momento. Dessa forma,
*  é possível saber a quantidade de trocas totais, sem utilizar um array auxiliar.
*
*   Complexidade de tempo: O(n)
*   Complexidade de espaço: O(1)
* */

public class FindMinSwapsMethod2 {

    public static void main(String[] args) {

        int[] array = { 0, 0, 1, 0, 1, 0, 1, 1 };

        int quantity = minSwaps(array);

        System.out.println(quantity);
    }

    public static int minSwaps(int[] array) {

        int count = 0;
        int numUnplacedZeros = 0;
        int size = array.length;

        for (int index = size - 1; index >= 0; index--) {

            // Itera pelo array, de trás para frente, contando a quantidade de zeros. Quando é encontrado um número "1"
            // a quantidade de vezes que ele precisa ser trocado é igual a quantidade de zeros acumulados até o momento.
            if (array[index] == 0) {
                numUnplacedZeros++;
            }
            else {
                count += numUnplacedZeros; // Adiciona a quantidade de zeros ao total, caso o número seja "1".
            }
        }

        return count;
    }
}