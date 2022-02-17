package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementare l'algoritmo di ricerca dicotomica su array ordinati di interi.
 */
public class RicercaDicotomica {
    public static void main(String[] args) {
        /*
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        int key = myObj.nextInt();
        int low = 0;
        int high = vector.size() - 1;
        System.out.println(binarySearch(vector, key, low, high));

         */

        int[] A = {4, 6, 7, 8, 10, 15, 22, 27, 30};
        int v = 27;
        int i = 0;
        int j = A.length - 1;
        System.out.println("La chiave cercata ha indice: " + binarySearch(A, v, i, j));

        int[] B = {2, 4, 5, 6, 7, 9, 8, 6, 3, 1, 0};
        int low = 0;
        int high = B.length - 1;
        System.out.println("Il massimo è: " + SearchMaxArray(B, low, high));
        System.out.println("Il massimo è: " + findMax(B, low, high));
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
    public static int binarySearch(ArrayList<Integer> lista, int key, int low, int high) {
        if (high < low) {
            return -1;
        }

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == lista.get(middle)) {
                return middle;
            }
            if (key < lista.get(middle)) {
                // If key is smaller than middle, then it can only be present in left sub-array
                high = middle - 1;
            } else {
                // Else the key can only be present in right sub-array
                low = middle + 1;
            }
        }

        return -1;
    }

    /**
     * BinarySearch of an element
     *
     * @param A a vector of integers
     * @param v the key to serch
     * @param i the first index of the array A
     * @param j the last index of the array A
     * @return the key searched in the vector
     */
    public static int binarySearch(int[] A, int v, int i, int j) {
        if (i > j) {
            return 0;

        } else {
            int m = ((i + j) / 2);
            if (A[m] == v) {
                return m;

            } else if (A[m] < v) {
                return binarySearch(A, v, m + 1, j);

            } else {
                return binarySearch(A, v, i, m - 1);
            }
        }
    }

    /**
     * @param A
     * @param start
     * @param end
     * @return
     */
    public static int SearchMaxArray(int[] A, int start, int end) {
        int max, max1 = 0;
        if (start == end) {
            return A[start];

        } else if (A[start] < A[end]) {
            max = SearchMaxArray(A, start + 1, end);
        } else {
            max = SearchMaxArray(A, start, end - 1);
        }

        if (max >= max1) {
            max1 = max;
        }

        return max1;
    }

    /**
     *
     * @param data
     * @param a
     * @param b
     * @return
     */
    public static int findMax(int[] data, int a, int b) {
        if (b - a <= 1) {
            return Math.max(data[a], data[b]);
        } else {
            int mid = (a + b) / 2;
            int leftMax = findMax(data, a, mid);
            int rightMax = findMax(data, mid + 1, b);
            return Math.max(leftMax, rightMax);
        }
    }

    // requires an input Scanner object (e.g. in = new Scanner(System.in); )
    public static ArrayList<Integer> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        // convert array of strings into array of integers
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
            {
                arr.add(Integer.parseInt(token));
            }
        }

        return arr;
    }
}
