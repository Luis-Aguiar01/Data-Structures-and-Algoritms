package arrays;

import java.util.Stack;

public class LeadersInArrayMethod3 {

    public static void main(String[] args) {

        int[] arr = { 16, 17, 4, 3, 5, 2 };
        int n = arr.length;
        printLeaders(arr, n);
    }

    // Complexidade O(n)
    public static void printLeaders(int[] arr, int size) {

        // Segue a mesma lógica do método anterior, no entanto, armazena cada líder em uma stack, fazendo com que o maior líder seja o que foi inserido por último na stack, sendo a impressão dos valores mais coerente dessa forma.

        Stack<Integer> stack = new Stack<Integer>();
        stack.push( arr[size - 1] );

        for ( int i = size - 2; i >= 0; i-- ) {
            if ( arr[i] >= stack.peek() ) {
                stack.push( arr[i] );
            }
        }

        while ( !stack.empty() ) {
            System.out.print( stack.pop() + " " );
        }
    }
}