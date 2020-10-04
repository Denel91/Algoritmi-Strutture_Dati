package Exercises;

/**
 * Problema di ricerca:
 *
 * Input: una sequenza di n numeri A = (a1, a2, a3, a4,...,an) e un valore v.
 * Output: un indice i tale che v = A[i] o il valore speciale NIL se v non figura in A.
 *
 * @version 04/10/2020
 */

public class LinearSearch {
    public static void main(String[] args) {
        int[] vector = {2, 4, 5, 7, 9};
        int key = 7;
        int key_2 = 6;
        search(vector, key);
        search(vector, key_2);
    }

    /**
     * Ricerca Lineare
     *
     * @param array un array di Integers
     * @param key l'elemento da cercare nell'array
     */
    public static void search(int[] array, int key) {
        int pos = 0;
        boolean found = false;

        while (pos < array.length && !found) { // scorro linearmente una posizione dopo l'altra
            if (array[pos] == key) {
                found = true;

            } else {
                pos++;
            }
        }

        if (found) {
            System.out.println("Found at position: " + pos);

        } else {
            System.out.println("Not Found");
        }
    }
}
