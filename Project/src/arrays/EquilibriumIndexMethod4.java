package arrays;

import java.util.List;

/*
*  O objetivo do código atual é encontrar o índice de equilíbrio em um array. Para isso, a solução utilizada, primeiro
*  soma todos os elementos do array (lista), e armazena em uma variável 'right', depois disso, utilizando um looping,
*  inicializamos ele no segundo elemento da lista (index 1) e então retiramos ele do total (right) de modo que
*  este represente soma de todos os elementos da direita, menos do índex em questão dentro do looping. Após isso,
*  na variável 'left' é armazenado todos os elementos à esquerda do elemento do índice atual do looping, sendo que dessa forma
*  é possível comparar a soma dos elementos a esquerda e a direita, em relação ao índice atual no looping.
*
*  Complexidade de tempo: O(n)
*  Complexidade de espaço: O(1)
*/
public class EquilibriumIndexMethod4 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 7, 3, 6, 5, 6);
        int result = pivotIndex(nums);

        System.out.println("First Point of equilibrium is at index " + result);
    }

    public static int pivotIndex(List<Integer> nums) {

        int left = 0;
        int pivot = 0;
        int right = 0;

        for (int i = 1; i < nums.size(); i++) {
            right += nums.get(i);
        }

        while (pivot < nums.size() - 1 && right != left) {
            pivot++;
            right -= nums.get(pivot);
            left += nums.get(pivot - 1);
        }

        return (left == right) ? pivot : -1;
    }
}