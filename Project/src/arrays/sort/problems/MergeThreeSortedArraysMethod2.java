package arrays.sort.problems;

import java.util.ArrayList;

public class MergeThreeSortedArraysMethod2 {

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 5 };
        int[] B = { 6, 7, 8, 9 };
        int[] C = { 10, 11, 12 };

        mergeThreeSortedArrays(A, B, C);
    }

    public static void mergeThreeSortedArrays(int[] A, int[] B, int[] C) {

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while(i < A.length && j < B.length && k < C.length) {

            int a = A[i];
            int b = B[j];
            int c = C[k];

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

        while (i < A.length && j < B.length) {

            if (A[i] <= B[j]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(B[j]);
                j++;
            }
        }

        while (j < B.length && k < C.length) {

            if (B[j] <= C[k]) {
                list.add(B[j]);
                j++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }

        while (i < A.length && k < C.length) {

            if (A[i] < C[k]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }

        while (i < A.length) {
            list.add(A[i]);
            i++;
        }

        while (j < B.length) {
            list.add(B[j]);
            j++;
        }

        while (k < C.length) {
            list.add(C[k]);
            k++;
        }

        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}