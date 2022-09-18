package Insertion;

import java.util.Arrays;

/**
 * Insertion-Sort
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] value = {5, 2, 4, 6, 1, 3};
        int[] data = {100, 98, 97, 37, 45, 68, 34, 69, 42, 96, 58, 36, 70, 62, 66, 33, 31, 30, 10, 20, 22, 40, 41};

        System.out.println(Arrays.toString(value)); // [5, 2, 4, 6, 1, 3]
        insertionSort(value);
        System.out.println(Arrays.toString(value)); // [1, 2, 3, 4, 5, 6]

        System.out.println(Arrays.toString(data)); // [100, 98, 97, 37, 45, 68, 34, 69, 42, 96, 58, 36, 70, 62, 66, 33, 31, 30, 10, 20, 22, 40, 41]
        insertionSort(data);
        System.out.println(Arrays.toString(data)); // [10, 20, 22, 30, 31, 33, 34, 36, 37, 40, 41, 42, 45, 58, 62, 66, 68, 69, 70, 96, 97, 98, 100]
    }

    /**
     * Ordinamento crescente di un array d' interi per inserimento
     * Complessità:
     * Caso ottimo: O(n)
     * Caso medio: O(n^2)
     * Caso peggiore: O(n^2)
     *
     * @param data the array of Integers
     */
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int j = 1; j < n; j++) { // inizia dal secondo elemento
            int key = data[j]; // chiave corrente
            int i = j - 1;

            // verifico se l'elemento precedente è maggiore dell'elemento corrente
            // e in caso positivo eseguo il corpo del ciclo while.
            while (i > -1 && data[i] > key) {
                data[i + 1] = data[i];
                i--;
            }

            data[i + 1] = key;
        }
    }
}
