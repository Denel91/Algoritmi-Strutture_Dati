package Exercises;

import static Merge.MergeSort.*;

/**
 * Dato un vettore A di interi di lunghezza n e dato K, decidere se esistono
 * A[i] e A[j] con i diverso da j tali che A[i] + A[j] = K.
 */
public class Search_Sum_Of_K {
    public static void main(String[] args) {
        int[] vector = {1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12};
        int key = 29;
        search_K(vector, key); // [14, 15]
        arrayTwoCandidates(vector, key); // [14, 15]
    }

    /**
     * Versione Ricorsiva
     *
     * @param A un vettore di interi
     * @param k la somma, se esiste, tra due elementi del vettore
     */
    public static void search_K(int[] A, int k) {
        int p = 0, q = A.length - 1;
        mergeSort(A, p, q);
        searchSum(A, p, q, k);
    }

    /**
     * Versione Ricorsiva
     *
     * @param A un vettore di interi
     * @param p l'indice del primo elemento del vettore
     * @param q l'indice dell'ultimo elemento del vettore
     * @param k la somma, se esiste, tra due elementi del vettore
     */
    public static void searchSum(int[] A, int p, int q, int k) {
        if (p == q) {
            System.out.println("No Values!");

        } else if (A[p] + A[q] == k) {
            System.out.println("[" + A[p] + ", " + A[q] + "]");

        } else if (A[p] + A[q] < k) {
            searchSum(A, p + 1, q, k);

        } else {
            searchSum(A, p, q - 1, k);
        }
    }

    /**
     * Versione Iterativa
     *
     * @param A un vettore di interi
     * @param k la somma, se esiste, tra due elementi del vettore
     */
    public static void arrayTwoCandidates(int[] A, int k) {
        int p = 0, q = A.length - 1;
        mergeSort(A, p, q);

        if (p == q) {
            System.out.println("No Values!");
        }

        while (p < q) {
            if (A[p] + A[q] == k) {
                System.out.println("[" + A[p] + ", " + A[q] + "]");
                return;

            } else if (A[p] + A[q] < k) {
                p++;

            } else {
                q--;
            }
        }
    }
}

