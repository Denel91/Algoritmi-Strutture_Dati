package Radix;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] testData = {26, 14, 105, 15, 16, 3, 13};
        System.out.println(Arrays.toString(radixSort(testData, 3))); // [3, 13, 14, 15, 16, 26, 105]

        int[] test = {1, 5, 7, 9, 11, 13, 14, 15, 2, 3, 4, 6, 8, 10, 12}; // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
        System.out.println(Arrays.toString(radixSort(test, 2)));
    }

    /*
     * This is a special implementation of counting sort,
     * which sort on a particular digit d, in this case k = 10.
     */
    public static int[] countingSortOnDigit(int[] data, int d) {
        int modulus1 = (int) Math.pow(10, d);
        int modulus2 = (int) Math.pow(10, d - 1);
        int[] ret = new int[data.length];
        int[] temp = new int[10];

        for (int j = 0; j < data.length; j++) {
            int digit = ((data[j] % modulus1) - (data[j] % modulus2)) / modulus2;
            temp[digit]++;
        }

        for (int i = 0; i < temp.length - 1; i++) {
            temp[i + 1] += temp[i];
        }

        for (int i = data.length - 1; i >= 0; i--) {
            int digit = ((data[i] % modulus1) - (data[i] % modulus2)) / modulus2;
            ret[temp[digit] - 1] = data[i];
            temp[digit]--;
        }

        return ret;
    }

    /**
     * Complessità: Θ(n)
     *
     * @param arr
     * @param d
     * @return
     */
    public static int[] radixSort(int[] arr, int d) {
        for (int i = 1; i <= d; i++) {
            arr = countingSortOnDigit(arr, i);
        }

        return arr;
    }
}
