package Exercises;

import static Merge.MergeSort.*;

/**
 * Cerca l'elemento ripetuto in un Vettore A di lunghezza n.
 */
public class SearchRepetition {
    public static void main(String[] args) {
        int[] vector = {1, 5, 7, 9, 11, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12};
        System.out.println("The repeated element is: " + searchRepetition(vector));
    }

    /**
     * Cerca l'elemento ripetuto nel vettore
     *
     * @param A un vettore di interi
     * @return l'elemento ripetuto se c'è, altrimenti ritorna -1
     */
    public static int searchRepetition(int[] A) {
        int p = 0, q = A.length - 1;
        mergeSort(A, p, q);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                return A[i];
            }
        }

        return -1;
    }
}
