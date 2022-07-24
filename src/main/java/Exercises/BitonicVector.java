package Exercises;

import java.util.Arrays;

/**
 * class BitonicVector
 */
public class BitonicVector {
    public static void main(String[] args) {
        int[] vector = {2, 4, 5, 7, 9, 8, 6, 3, 1, 0};
        int low = 0;
        int high = vector.length - 1;
        int n = vector.length;
        System.out.println(findMaxElement(vector, low, high));
        System.out.println(Arrays.toString(sortBitonicVector(vector, n)));

        int[] A = {2, 4, 6, 8, 10, 3, 1};
        int low1 = 0;
        int high1 = A.length - 1;
        int n1 = A.length;
        System.out.println(findMaxElement(A, low1, high1));
        System.out.println(Arrays.toString(sortBitonicVector(A, n1)));
    }

    /**
     * 1. Se l'elemento centrale è più grande di entrambi i suoi elementi adiacenti,
     * ritorniamo A[mid] perchè è il massimo.
     *
     * 2. Se l'elemento centrale è più grande dell'elemento successivo e più piccolo dell'elemento
     * precedente, l'elemento più grande sta nella parte sinistra del vettore.
     * Es: {3,23,10,8,7,6};
     *
     * 3. Se l'elemento centrale è più grande del suo elemento precedente e più piccolo del suo
     * successivo, allora il massimo sta nella parte destra del vettore.
     * Es: {2,4,6,8,10,3,1}
     *
     * Complessità: O(lg n)
     * @param A
     * @param low
     * @param high
     * @return
     */
    public static int findMaxElement(int[] A, int low, int high) {
        if (low == high) {
            return A[low];
        }

        if ((low + 1 == high) && A[low] >= A[high]) {
            return A[low];
        }

        if ((low + 1 == high) && A[low] < A[high]) {
            return A[high];
        }

        int mid = (low + high) / 2;

        if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
            return A[mid];

        } else if (A[mid] > A[mid + 1] && A[mid] < A[mid - 1]) {
            return findMaxElement(A, low, mid - 1);

        } else {
            return findMaxElement(A, mid + 1, high);
        }
    }

    /**
     * 1. L'idea è di inizializzare una variabile k alla potenza più alta di 2 nella
     * dimensione dell'array in modo da confrontare elementi che sono tra loro distanti k.
     *
     * 2. Scambio gli elementi se non sono in ordine crescente
     *
     * 3. Si riduce k della metà e si ripete il processo fino a quando k diventa zero.
     *
     * Complessità: O(n log n)
     * @param A un array di interi
     * @param n lunghezza del vettore A
     * @return
     */
    public static int[] sortBitonicVector(int[] A, int n) {
        int k = (int) (Math.log(n) / Math.log(2));
        k = (int) Math.pow(2, k);

        while (k > 0) {
            for (int i = 0; i + k < n; i++) {
                if (A[i] > A[i + k]) {
                    int temp = A[i];
                    A[i] = A[i + k];
                    A[i + k] = temp;
                }
            }

            k = k / 2;
        }

        return A;
    }
}
