package Bubble;

import java.util.Arrays;

/**
 * BubbleSort class
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] value = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(value)); // [5, 2, 4, 6, 1, 3]
        bubbleSort(value);
        System.out.println(Arrays.toString(value)); // [1, 2, 3, 4, 5, 6]

        int[] vector = {1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12};
        System.out.println(Arrays.toString(vector)); // [1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12]
        bubbleSort(vector);
        System.out.println(Arrays.toString(vector)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

        int[] data = {5, 2, 4, 6, 1, 3, 7};
        System.out.println(Arrays.toString(data));
        bubble_Sort(data);
        System.out.println(Arrays.toString(data)); // [1, 2, 3, 4, 5, 6, 7]

        int[] A = {6, 4, 1, 2, 5, 3};
        System.out.println(Arrays.toString(A));
        bubble_Sort(A);
        System.out.println(Arrays.toString(A)); // [1, 2, 3, 4, 5, 6]

        int[] B = {-2, 0, -4, 1, 5, 3, 2, 4, 6, -1, 8};
        System.out.println(Arrays.toString(B));
        bubble_Sort(B);
        System.out.println(Arrays.toString(B)); // [-4, -2, -1, 0, 1, 2, 3, 4, 5, 6, 8]
    }

    /**
     * Ordina un insieme di elementi secondo la strategia di ordinamento “a bolle”
     *
     * @param A array di Integers
     */
    public static void bubbleSort(int[] A) {
        int flag = 1; // indica che l'insieme non è ordinato, mentre il valore flag = 0 segnala che la sequenza risulta ordinata.
        int stop = A.length - 1;
        while (flag == 1) {
            flag = 0;
            for (int i = 0; i < stop; i++) {
                int temp;
                if (A[i] > A[i + 1]) {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    flag = 1;
                }
            }

            stop = stop - 1;
        }
    }

    /**
     * Ordina un insieme di elementi secondo la strategia di ordinamento “a bolle”
     * T. H. Cormen implementation
     *
     * @param A un vettore di numeri interi
     */
    public static void bubble_Sort(int[] A) {
        boolean flag;
        for (int i = 0; i < A.length - 1; i++) {
            flag = false; // indica che l'insieme non è ordinato
            for (int j = A.length - 1; j > i; j--) {
                int temp;
                if (A[j] < A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                    flag = true;
                }
            }

            if (!flag)
               break;
        }
    }
}
