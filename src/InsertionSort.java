import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] value = {0, 1, 2, 3, 4, 5, 7, 6, 9, 8, 10};
        System.out.println(Arrays.toString(value));
        insertionSort(value);
        System.out.println(Arrays.toString(value));
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int j = 1; j < n; j++) {
            int i = j - 1;
            int key = a[j];

            while (i > 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }

            a[i + 1] = key;
        }
    }
}
