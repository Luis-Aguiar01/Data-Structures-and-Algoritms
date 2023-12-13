package arrays.search.problems;

import java.util.Arrays;

public class FindMajorityElementMethod5 {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 1, 3, 5, 1 };
        int size = arr.length;

        System.out.println(majorityElement(arr, size));
    }

    public static int majorityElement(int[] arr, int size) {

        Arrays.sort(arr);

        int count = 1;
        int countElement = -1;
        int currentElement = arr[0];
        int element = 0;

        for (int i = 1; i <= size; i++) {

            if ( currentElement == arr[i] ) {
                count++;
            }
            else {
                count = 1;
                currentElement = arr[i];
            }

            if ( countElement < count ) {
                countElement = count;
                element = arr[i];

                if (countElement > (size / 2)) {
                    break;
                }
            }
        }

        boolean result = ( countElement > (size / 2) );

        return  (result) ? element : -1;
    }
}