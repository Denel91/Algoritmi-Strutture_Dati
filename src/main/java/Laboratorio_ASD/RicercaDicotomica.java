package Laboratorio_ASD;

/**
 * Implementare l'algoritmo di ricerca dicotomica su array ordinati di interi.
 */
public class RicercaDicotomica {
    public static void main(String[] args) {
        int[] vector = {3, 7, 8, 11, 15, 24};
        int key = 15;
        int low = 0;
        int high = vector.length - 1;
        System.out.println(key);
        System.out.println("Searched Key found at index: " + binarySearch(vector, key, low, high)); // 4
    }

    /**
     * Binary search of an element within an array
     *
     * @param lista an array of integers sorted
     * @param key   the value of the element in lista
     * @param low   the first index of lista; REQUIRE = 0
     * @param high  the last index of lista, is equal to its length – 1.
     * @return index of key if it is present in source, else return -1.
     */
    public static int binarySearch(int[] lista, int key, int low, int high) {
        if (high < low) {
            return -1;
        }

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == lista[middle]) {
                return middle;
            }
            if (key < lista[middle]) {
                // If key is smaller than middle, then it can only be present in left sub-array
                high = middle - 1;
            } else {
                // Else the key can only be present in right sub-array
                low = middle + 1;
            }
        }

        return -1;
    }
}
