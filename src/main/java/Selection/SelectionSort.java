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
    }

    /**
     * Ordinamento crescente di un array di interi per selezione
     *
     * @param data the array of Integers
     */
    public static void selectionSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int posMin = i;

            for (int j = (i + 1); j < n; j++) {
                if (data[j] < data[posMin]) {
                    posMin = j;
                }
            }

            if (posMin != i) {
                int temp = data[i];
                data[i] = data[posMin];
                data[posMin] = temp;
            }
        }
    }
}
