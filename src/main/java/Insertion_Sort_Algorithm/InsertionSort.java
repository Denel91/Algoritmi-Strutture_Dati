package Insertion_Sort_Algorithm;

import java.util.Arrays;

/**
 * Insertion-Sort
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] value = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(value)); // [5, 2, 4, 6, 1, 3]
        insertionSort(value);
        System.out.println(Arrays.toString(value)); // [1, 2, 3, 4, 5, 6]
    }

    /**
     * Ordinamento crescente di un array di interi per inserimento
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
