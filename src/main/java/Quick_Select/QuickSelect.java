package Quick_Select;

import java.util.Arrays;

/**
 * class QuickSelect
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println(Arrays.toString(array)); // [2, 8, 7, 1, 3, 5, 6, 4]
        int k = 5;
        int kthSmallest = quickSelect(array, 0, array.length - 1, k);
        System.out.println(kthSmallest); // 5
    }

    /**
     * QuickSelect is a selection algorithm to find the K-th smallest element in an unsorted list.
     *
     * @param list  un array di interi
     * @param left  indice del primo elemento del vettore
     * @param right indice dell'ultimo elemento del vettore
     * @param k il k-esimo elemento più piccolo da cercare nel vettore
     * @return il k-esimo elemento più piccolo in un vettore non ordinato
     */
    public static int quickSelect(int[] list, int left, int right, int k) {
        if (left == right) {
            return list[left];
        }

        while (left <= right) {
            int pivotIndex = partition(list, left, right);
            if (pivotIndex == k - 1) {
                return list[pivotIndex];
            } else if (pivotIndex > k - 1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return -1;
    }

    /**
     * Procedura di supporto per scambiare due elementi in un Vettore.
     * Scambia l'elemento in posizione i con l'elemento in posizione j.
     *
     * @param array un vettore di interi
     * @param i indice del primo elemento da scambiare
     * @param j indice del secondo elemento da scambiare
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Lomuto Partition
     *
     * @param A un vettore di interi
     * @param p indice iniziale del vettore
     * @param q indice finale del vettore
     * @return l'indice del pivot
     */
    private static int partition(int[] A, int p, int q) {
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
}
