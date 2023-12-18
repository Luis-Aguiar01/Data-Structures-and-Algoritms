package arrays.sort.problems;

import java.util.ArrayList;

public class MergeThreeSortedArraysMethod3 {

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 5 };
        int[] B = { 6, 7, 8, 9 };
        int[] C = { 10, 11, 12 };

        ArrayList<Integer> finalList = mergeThreeSortedArrays(A, B, C);

        printList(finalList);
    }

    public static ArrayList<Integer> mergeThreeSortedArrays(int[] A, int[] B, int[] C) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        int sizeArrayA = A.length;
        int sizeArrayB = B.length;
        int sizeArrayC = C.length;
        int i = 0, j = 0, k = 0;

        while (i < sizeArrayA || j < sizeArrayB || k < sizeArrayC) {

            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if (i < sizeArrayA) {
                a = A[i];
            }
            if (j < sizeArrayB) {
                b = B[j];
            }
            if (k < sizeArrayC) {
                c = C[k];
            }

            if (a <= b && a <= c) {
                list.add(a);
                i++;
            }
            else if (b <= a && b <= c) {
                list.add(b);
                j++;
            }
            else {
                list.add(c);
                k++;
            }
        }

        return list;
    }

    public static void printList(ArrayList<Integer> list) {
        for (int value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }



}
