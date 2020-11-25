package Bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * BucketSort
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = {.78, .17, .39, .26, .72, .94, .21, .12, .23, .68};
        bucketSort(array);
        System.out.println(Arrays.toString(array)); // [0.12, 0.17, 0.21, 0.23, 0.26, 0.39, 0.68, 0.72, 0.78, 0.94]
    }

    /**
     * Ordina un vettore che ha una distribuzione uniforme degli elementi.
     *
     * @param A un array di double da ordinare
     */
    public static void bucketSort(double[] A) {
        int n = A.length;
        if (n <= 0) {
            return;
        }

        // Creo un array di liste concatenate
        ArrayList<Double>[] bucket = new ArrayList[n];

        // 1) Create empty buckets
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<>();
        }

        // 2) Add elements into the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) A[i] * n;
            bucket[bucketIndex].add(A[i]);
        }

        // 3) Sort the elements of each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]);
        }

        // 4) Concatenate all bucket into A[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                A[index] = bucket[i].get(j);
                index++;
            }
        }
    }
}
