package Selection;

import java.util.Arrays;

/**
 * Selection-Sort
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] value = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(value)); // [5, 2, 4, 6, 1, 3]
        selectionSort(value);
        System.out.println(Arrays.toString(value)); // [1, 2, 3, 4, 5, 6]

        int[] data = {7, 5, 4, 2};
        System.out.println(Arrays.toString(data)); // [7, 5, 4, 2]
        selectionSort(data);
        System.out.println(Arrays.toString(data)); // [2, 4, 5, 7]

        System.out.println("-- Recursive SelectionSort Test --");
        int[] array = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(array)); // [5, 2, 4, 6, 1, 3]
        recursiveSelectionSort(array, 0);
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5, 6]

        int[] vector = {8, 7, 9, 5, 3, 10, 6, 4, 2, 1};
        System.out.println(Arrays.toString(vector)); // [8, 7, 9, 5, 3, 10, 6, 4, 2, 1]
        recursiveSelectionSort(vector, 0);
        System.out.println(Arrays.toString(vector)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    /**
     * Ordinamento crescente di un array di interi per selezione
     *
     * Complessità:
     * Caso ottimo: O(n^2)
     * Caso medio: O(n^2)
     * Caso peggiore: O(n^2)
     *
     * @param data the array of Integers
     */
    public static void selectionSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int posMin = i; // indice dell'elemento minimo

            for (int j = (i + 1); j < n; j++) {
                if (data[j] < data[posMin]) { // confronto per trovare un nuovo minimo
                    posMin = j; // salvo l'indice del nuovo minimo
                }
            }

            // scambio il minimo trovato con il primo elemento
            if (posMin != i) {
                int temp = data[i];
                data[i] = data[posMin];
                data[posMin] = temp;
            }
        }
    }

    /**
     * SelectionSort ricorsivo
     *
     * @param data un array di Integers
     * @param p l'indice iniziale dell'array: REQUIRE = 0
     */
    public static void recursiveSelectionSort(int[] data, int p) {
        if (p < data.length) {
            int i = minSearch(data, p, data.length);
            swap(data, i, p);
            recursiveSelectionSort(data, p + 1);
        }
    }

    /**
     * Procedura di supporto per trovare l'indice minimo nell'array.
     *
     * @param data un array di Integer
     * @param k indice iniziale dell'array
     * @param h indice finale dell'array
     * @return la posizione in cui si trova l'elemento minimo
     */
    private static int minSearch(int[] data, int k, int h) {
        int min_value = data[k];
        int min_pos = k;

        for (int i = (k + 1); i < h; i++) {
            if (data[i] < min_value) {
                min_value = data[i];
                min_pos = i;
            }
        }

        return min_pos;
    }

    /**
     * Procedura di supporto per scambiare due elementi all'interno di un array
     * Scambia a[p] con a[q]
     *
     * @param a un array di Integers
     * @param p indice del primo elemento
     * @param q indice del secondo elemento
     */
    private static void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
