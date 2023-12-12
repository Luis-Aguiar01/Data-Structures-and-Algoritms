package arrays;

public class FindMajorityElementMethod3 {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 3, 1, 2 };
        int size = arr.length;
        printMajority(arr, size);
    }

    public static void printMajority(int[] arr, int size) {

        int candidate = findCandidate(arr, size);

        if ( isMajority(arr, size, candidate) ) {
            System.out.println(" " + candidate + " ");
        }
        else {
            System.out.println("No majority element");
        }
    }

    // Utilizando o algoritmo de votação de Moore, que retorna o elemento com uma maior chance de ser o majoritário.
    // Complexidade O(n)
    // Complexidade de espaço O(1)
    public static int findCandidate(int[] a, int size) {

        int majorityIndex = 0;
        int count = 1;

        for ( int i = 1; i < size; i++ ) {
            
            if ( a[majorityIndex] == a[i] ) {
                count++;
            }
            else {
                count--;
            }

            if ( count == 0 ) {
                majorityIndex = i;
                count = 1;
            }
        }

        return a[majorityIndex];
    }

    public static boolean isMajority(int[] a, int size, int candidate) {

        int count = 0;

        for ( int i = 0; i < size; i++ ) {
            if (a[i] == candidate) {
                count++;
            }
        }

        if ( count > ( size / 2 ) ) {
            return true;
        }

        return false;
    }
}