package arrays.search.problems;

public class CheckForMajorityElementInASortedArrayMethod2 {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 3, 3, 3, 10 };
        int n = arr.length;
        int x = 3;

        if (isMajority(arr, n, x)) {
            System.out.println(x + " appears more than " + n / 2 + " times in arr[]");
        }
        else {
            System.out.println(x + " does not appear more than " + n / 2 + " times in arr[]" );
        }
    }

    public static int binarySearch(int[] arr, int low, int high, int x) {

        if (high >= low) {

            int mid = ( low + high ) / 2;

            // A segunda condição, garante que a primeira ocorrência do valor seja a que terá o índice retornado, pois o elemento precisa ser menor do que o anterior e também igual ao valor procurado. A primeira condição trata o caso de o primeiro elemento do array ser o meio, o que causaria problemas na segunda condição, caso seja verificado [mid - 1] = -1
            if ( ( mid == 0 ) || ( ( x > arr[mid - 1] ) && ( arr[mid] == x ) ) ) {
                return mid;
            }
            else if ( x > arr[mid] ) {
                return binarySearch(arr, ( mid + 1 ), high, x);
            }
            else {
                return binarySearch(arr, low, ( mid - 1 ), x);
            }
        }

        return -1;
    }

    public static boolean isMajority(int[] arr, int n, int x) {

        int i = binarySearch(arr,0, ( n - 1 ), x);

        if (i == -1) {
            return false;
        }
        
        // A primeira condição verifica se o índice passado somado com a metade do array é menor ou igual ao total de índices dentro do array, evitando gerar uma exceção.
        if ( (( i + n / 2 ) <= ( n - 1 )) && ( arr[i + n / 2] == x ) ) {
            return true;
        }

        return false;
    }
}