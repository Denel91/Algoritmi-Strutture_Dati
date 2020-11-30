package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Scrivere un programma che riceva in input un array V ordinato di interi e, su una nuova riga, un ulteriore intero S.
 * Il programma deve restituire una qualunque coppia ordinata (i,j) di posizioni nell'array V tale che i < j e V[i] + V[j] = S.
 * Se una tale coppia (i,j) di interi non esiste, il programma deve segnalare il caso ritornando la coppia (−1,−1).
 */
public class SumOfK {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        int key = myObj.nextInt();
        System.out.println(findIndex(vector, key));
        System.out.println(arrayTwoCandidates(vector, key));
        System.out.println(findIindexId(vector, key));
    }

    /**
     * Versione Iterativa
     * Cerca la coppia (i,j) nell'array A tale che i < j e A[i] + A[j] = Key
     *
     * @param A un vettore di interi
     * @param k la somma, se esiste, tra due elementi del vettore
     */
    public static ArrayList<Integer> arrayTwoCandidates(ArrayList<Integer> A, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int p = 0, q = A.size() - 1;

        if (p == q) {
            System.out.println("No Values!");
        }

        while (p < q) {
            if (A.get(p) + A.get(q) == k) {
                result.add(p);
                result.add(q);
                return result;

            } else if (A.get(p) + A.get(q) < k) {
                p++;

            } else {
                q--;
            }
        }

        result.add(-1);
        result.add(-1);
        return result;
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

    /**
     * Cerca la coppia (i,j) nell'array A tale che i < j e A[i] + A[j] = Key
     *
     * @param A
     * @param key
     * @return
     */
    public static ArrayList<Integer> findIndex(ArrayList<Integer> A, int key) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == key) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }

        res.add(-1);
        res.add(-1);
        return res;
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
     * @param A
     * @param key
     * @return
     */
    public static ArrayList<Integer> findIindexId(ArrayList<Integer> A, int key) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int j = binarySearch(A, key - A.get(i), i, A.size() - 1);
            if (j >= 0) {
                res.add(i);
                res.add(j);
                return res;
            }
        }

        res.add(-1);
        res.add(-1);
        return res;
    }
}
