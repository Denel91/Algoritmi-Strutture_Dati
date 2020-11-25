package Counting;

import java.util.Arrays;

/**
 * CountingSort
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = new int[array.length];
        int k = 5;
        System.out.println(Arrays.toString(countingSort(array, B, k))); // [0, 0, 2, 2, 3, 3, 3, 5]
    }

    /**
     * Ordina gli elementi del vettore A
     *
     * @param A l'array da ordinare
     * @param B l'array di output ordinato
     * @param k il massimo elemento nel vettore A
     * @return il vettore B ordinato
     */
    public static int[] countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];

        // step 1
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }

        for (int i = 0; i < A.length; i++) {
            C[A[i]] = C[A[i]] + 1;
        }

        // step 2
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // step 3: populate B
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }

        return B;
    }
}


