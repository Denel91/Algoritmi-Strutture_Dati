package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Scrivere un programma che riceva in input un array V di interi (non necessariamente ordinato!)
 * e restituisca una coppia (i,j) di posizioni nell'array V tale che i ≤ j e la differenza V[j]−V[i] sia massima.
 */
public class MaxDiff {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        int dimension = vector.size();
        System.out.println(maxDiff(vector, dimension));

        int[] w = {14, 16, 1, 5, 13, 0, 3};
        int t = w.length;
        int[] res = maxDiff(w, t);
        System.out.println(Arrays.toString(res));
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
     * @param A   un ArrayList di Interi
     * @param dim la dimensione dell'ArrayList
     * @return restituisce la coppia (i,j)
     */
    public static ArrayList<Integer> maxDiff(ArrayList<Integer> A, int dim) {
        ArrayList<Integer> res = new ArrayList<>();
        int min = 0;
        int i = 0;
        int j = 0;
        for (int k = 1; k < dim; k++) {
            if (A.get(k) < A.get(min)) {
                min = k;
            }

            if ((A.get(k) - A.get(min)) > (A.get(j) - A.get(i))) {
                i = min;
                j = k;
            }
        }

        res.add(i);
        res.add(j);
        return res;
    }

    /**
     * @param A   un array di Interi
     * @param dim la dimensione dell'Array
     * @return restituisce la coppia (i,j)
     */
    public static int[] maxDiff(int[] A, int dim) {
        int[] res = new int[2];
        int min = 0;
        int i = 0;
        int j = 0;
        for (int k = 1; k < dim; k++) {
            if (A[k] < A[min]) {
                min = k;
            }

            if ((A[k] - A[min]) > (A[j] - A[i])) {
                i = min;
                j = k;
            }
        }

        res[0] = i;
        res[1] = j;
        return res;
    }
}
