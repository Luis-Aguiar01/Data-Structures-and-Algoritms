package arrays.search.problems;

public class CheckForMajorityElementInASortedArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 4, 4, 4 };
        int n = arr.length;
        int x = 4;

        if (isMajority(arr, n, x)) {
            System.out.println(x + " appears more than " + n / 2 + " times in arr[]");
        }
        else {
            System.out.println(x + " does not appear more than " + n / 2 + " times in arr[]");
        }
    }

    public static boolean isMajority(int[] arr, int n, int x) {

        int lastIndex = 0;

        lastIndex = (n % 2 == 0) ? (n / 2) : (n / 2) + 1;

        for (int i = 0; i < lastIndex; i++) {

            if (arr[i] == x && arr[i + n / 2] == x) {
                return true;
            }
        }

        return false;
    }
}