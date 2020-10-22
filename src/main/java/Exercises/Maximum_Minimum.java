package Exercises;

import java.util.Arrays;

/**
 * L’algoritmo Min-Max calcola il minimo ed il massimo tra i valori in un vettore A[p....q].
 */
public class Maximum_Minimum {
    public static void main(String[] args) {
        int[] A = {5, 4, 6, 2, 1, 3};
        int p = 0;
        int q = A.length - 1;
        System.out.println(Arrays.toString(min_max(A, p, q))); // --> (1,6)

        int[] vector = {1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12};
        int p1 = 0;
        int q1 = vector.length - 1;
        System.out.println(Arrays.toString(min_max(vector, p1, q1))); // --> (1,15)
    }

    /**
     * Calcola il minimo ed il massimo tra i valori in un vettore A[p....q].
     *
     * @param A un array di Integers
     * @param p indice iniziale dell'array
     * @param q indice finale dell'array
     * @return la coppia (min,max) trovata nel vettore A
     */
    public static int[] min_max(int[] A, int p, int q) {
        int[] result = new int[2];

        if (p + 1 >= q) {
            if (A[p] <= A[q]) {
                result[0] = A[p];
                result[1] = A[q];
                return result;

            } else {
                result[0] = A[q];
                result[1] = A[p];
                return result;
            }

        } else {
            int r = (p + q) / 2;
            int[] Left = min_max(A, p, r);
            int[] Right = min_max(A, r + 1, q);
            result[0] = Math.min(Left[0], Right[0]);
            result[1] = Math.max(Left[1], Right[1]);
            return result;
        }
    }
}
