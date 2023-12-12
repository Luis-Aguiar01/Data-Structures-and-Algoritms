package arrays;

import java.util.HashMap;

public class FindMajorityElementMethod4 {

    public static void main(String[] args) {
        int[] a = { 2, 2, 2, 2, 5, 5, 2, 3, 3 };
        findMajority(a);
    }

    // Complexidade de tempo: O(n) - No pior dos casos, precisa percorrer o array todo.
    // Complexidade de espaço: O(n) - No pior dos casos, precisa criar uma posição no map para cada valor diferente dentro do array.
    public static void findMajority(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]) + 1;
                map.put(arr[i], count);
            }
            else {
                map.put(arr[i], 1);
            }

            if ( map.get(arr[i]) > ( arr.length / 2 ) ) {
                System.out.println("Majority found: " + arr[i]);
                return;
            }
        }
    }
}