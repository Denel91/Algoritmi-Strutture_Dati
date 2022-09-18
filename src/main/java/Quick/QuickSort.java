package Quick;

import java.util.Arrays;

/**
 * Implementazione dell'algoritmo QuickSort, basato sul paradigma Divide et Impera.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] vector = {11, 15, 3, 5, 20, 1, 8, 25, 3, 10};
        System.out.println(Arrays.toString(vector)); // [11, 15, 3, 5, 20, 1, 8, 25, 3, 10]
        int r = partition(vector, 0, vector.length - 1);
        System.out.println("Posizione corretta del Pivot corrente: " + r); // 5
        System.out.println(Arrays.toString(vector)); // [3, 5, 1, 8, 3, 10, 15, 25, 20, 11]

        System.out.println("\nQuickSort test:");
        int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println(Arrays.toString(array)); // [2, 8, 7, 1, 3, 5, 6, 4]
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5, 6, 7, 8]
    }

    /**
     * Procedura di supporto per scambiare due elementi in un Vettore.
     * Scambia l'elemento in posizione i con l'elemento in posizione j.
     *
     * @param array un vettore
     * @param i l'indice del primo elemento da scambiare
     * @param j l'indice del secondo elemento da scambiare
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Complessità: Θ(n)
     *
     * @param A
     * @param p
     * @param q
     * @return
     */
    public static int partition(int[] A, int p, int q) {
        // choose a pivot
        int pivVal = A[q];
        int i = p - 1;
        for (int j = p; j <= q; j++) {
            if (A[j] <= pivVal) {
                i = i + 1;
                swap(A, i, j);
            }
        }

        return i;
    }

    /**
     * Complessità:
     * Caso ottimo: O(n lg n)
     * Caso medio: O(n lg n)
     * Caso peggiore: O(n^2)
     *
     * @param A
     * @param p
     * @param q
     */
    public static void quickSort(int[] A, int p, int q) {
        if (p < q) {
            int pivot = partition(A, p, q);
            quickSort(A, p, pivot - 1);
            quickSort(A, pivot + 1, q);
        }
    }
}
