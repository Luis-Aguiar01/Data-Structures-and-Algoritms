package arrays.sort.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*  Essa se trata de uma abordagem ingênua para resolver o problema de mesclar e ordenar 3 arrays
*  ordenados. No caso, há formas mais eficientes de fazer isso. Esta, simplesmente junta todos os
*  arrays em uma mesma lista, e depois ordena essa lista.
*
*  Complexidade de tempo: O((n+m+p) * log(n+m+p))  - Em que "m", "n" e "p" são os tamanhos dos arrays.
*  Complexidade de espaço: O(m+n+p) - O tamanho é proporcional a soma dos tamanhos dos outros arrays.
* */


public class MergeThreeSortedArraysMethod1 {

    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(1, 2, 3, 5);
        List<Integer> B = Arrays.asList(6, 7, 8, 9);
        List<Integer> C = Arrays.asList(10, 11, 12);

        List<Integer> D = mergeThreeSortedArrays(A, B, C);

        printList(D);
    }

    public static void printList(List<Integer> list) {

        for (int value : list) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static List<Integer> mergeThreeSortedArrays(List<Integer> A, List<Integer> B, List<Integer> C) {

        List<Integer> D = new ArrayList<>();

        // Adiciona todos os elementos de uma lista para outra.
        D.addAll(A);
        D.addAll(B);
        D.addAll(C);

        // Ordena a lista de forma crescente
        Collections.sort(D);

        return D;
    }
}