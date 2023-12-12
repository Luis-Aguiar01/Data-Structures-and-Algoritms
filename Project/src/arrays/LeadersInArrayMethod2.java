package arrays;

public class LeadersInArrayMethod2 {

    public static void main(String[] args) {

        int[] arr = { 16, 17, 4, 3, 5, 2 };
        int n = arr.length;
        printLeaders(arr, n);
    }

    // Complexidade O(n)
    public static void printLeaders(int[] arr, int size) {

        int maxValueFromRight = arr[size - 1];

        System.out.print(maxValueFromRight + " ");

        // Faz a comparação da direita para a esquerda, sempre guardando o maior valor. Caso um valor na posição esquerda seja maior do que o maior valor até então, todos os elementos a sua direita serão menores do que ele, ou seja, esse valor será um líder.

        for (int i = size - 2; i >= 0; i--) {
            if (maxValueFromRight < arr[i]) {
                maxValueFromRight = arr[i];
                System.out.print(maxValueFromRight + " ");
            }
        }
    }
}