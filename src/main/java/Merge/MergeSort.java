package Merge;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("- MergeSort test -");
        int[] array = {1, 5, 9, 2, 3, 4, 6, 7, 8, 10};
        int p = 0, r = array.length - 1;
        mergeSort(array, p, r);
        System.out.print("Sorted: ");
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        System.out.println("- Merge test -");
        int[] vector = {1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12};
        int p1 = 0, r1 = vector.length - 1, q = 7;
        System.out.println(Arrays.toString(vector)); // [1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12]
        merge(vector, p1,q,r1);
        System.out.println(Arrays.toString(vector)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
        mergeSort(vector, p1, r1);
        System.out.print("Sorted: ");
        System.out.println(Arrays.toString(vector)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

        System.out.println("- Merge test -");
        int[] A = {5, 2, 4, 6, 1, 3};
        int p2 = 0, r2 = A.length - 1;
        mergeSort(A, p2, r2);
        System.out.print("Sorted: ");
        System.out.println(Arrays.toString(A));
    }

    /**
     * Unisce due sottoarray in un unico array
     *
     * @param A un array contenente due sottoarray ordinati
     * @param p indice di inizio del primo array
     * @param q indice finale del primo array
     * @param r indice finale del secondo array
     */
    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        // sentinel values
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * Ordina un array in ordine crescente
     *
     * @param A l'array da ordinare
     * @param p indice di inizio dell'array da ordinare
     * @param r indice di fine dell'array da ordinare
     */
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }
}
