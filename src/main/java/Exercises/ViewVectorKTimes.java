package Exercises;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Sia A un array di n numeri naturali.
 * Si consideri il problema di stampare in ordine crescente tutti i numeri che
 * compaiono in A almeno n/k e volte, dove k > 0 è una costante.
 */
public class ViewVectorKTimes {
    public static void main(String[] args) {
        int[] A = {5, 3, 1, 7, 3, 6, 8, 3, 5, 2};
        System.out.println(countTheNumber(A, A.length, 4));
    }

    /**
     * Count the numbers in the array k times
     *
     * @param A
     * @param n
     * @param k
     * @return
     */
    public static ArrayList<Integer> countTheNumber(int[] A, int n, int k) {
        Arrays.sort(A);
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            B[A[i]] = B[A[i]] + 1;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            if (B[i] >= Math.ceil(n / k)) {
                answer.add(i);
            }
        }

        return answer;
    }
}
