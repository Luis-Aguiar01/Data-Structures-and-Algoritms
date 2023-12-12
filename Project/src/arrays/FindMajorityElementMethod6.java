package arrays;

/**
 * Utiliza a abordagem de divisão e conquista para encontrar um elemento majoritário no array.
 * Divide o array sucessivamente pela metade até restar apenas um elemento central.
 * Compara os elementos centrais das duas metades e conta suas ocorrências no array completo.
 * Retorna o elemento majoritário se existir, ou -1 se não houver.

 * Complexidade de tempo: O(n * log(n))
 * Complexidade de espaço: O(log(n))
 */

public class FindMajorityElementMethod6 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 3, 2 };
        int size = arr.length;

        findMajority(arr, size);
    }

    public static void findMajority(int[] arr, int size) {

        int majority = findMajorityUtil(arr, 0, size - 1);

        if (majority != -1) {
            System.out.println(majority);
        }
        else {
            System.out.println("No majority Elements");
        }
    }

    public static int findMajorityUtil(int[] arr, int low, int high) {

        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;

        // Faz sucessivas chamadas recursivas, dividindo o array pela metade em cada uma delas
        // até sobrar um único elemento central, o qual é comparado com o elemento central da segunda metade
        // caso ele seja igual, encontramos o valor central, se não, precisamos contar a ocorrência de cada um deles array
        int leftMajority = findMajorityUtil(arr, low, mid);
        int rightMajority = findMajorityUtil(arr, mid + 1, high);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // Conta quantas vezes aparece o elemento central descoberto nas duas metades do array
        int leftCount = countOccurrences(arr, high - low + 1, leftMajority);
        int rightCount = countOccurrences(arr, high - low + 1, rightMajority);

        if (leftCount > ( high - low + 1 ) / 2) {
            return leftMajority;
        }
        else if (rightCount > ( high - low + 1 ) / 2) {
            return rightMajority;
        }

        return -1;
    }

    public static int countOccurrences(int[] arr, int size, int num) {

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        return count;
    }
}