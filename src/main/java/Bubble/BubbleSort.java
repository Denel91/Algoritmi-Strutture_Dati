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
}
