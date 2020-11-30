package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Scrivere un programma che riceva in input un array V di interi non-negativi (non necessariamente ordinati) e, su
 * una nuova riga, un intero S, e restituisca, se esiste, un intervallo [i,j] di posizioni nell'array V, con i ≤ j,
 * tale che V[i] + V[i+1] + … + V[j] = S.
 */
public class VectorInterval {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        int key = myObj.nextInt();
        System.out.println(trovaIntervallo(vector, key));
    }

    // requires an input Scanner object (e.g. in = new Scanner(System.in); )
    public static ArrayList<Integer> scanArray(java.util.Scanner in) {
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
     * @param V un ArrayList di Interi
     * @param s la somma in un intervallo (i, j)
     * @return un intervallo [i,j] di posizioni nell' ArrayList V
     */
    public static ArrayList<Integer> trovaIntervallo(ArrayList<Integer> V, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = V.get(0);

        if (V.size() == 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        while (j < V.size()) {
            if (m == s) {
                result.add(i);
                result.add(j);
                return result;
            } else if (m < s) {
                j++;
                m += V.get(j);

            } else {
                i++;
                m -= V.get(i - 1);
            }
        }

        result.add(-1);
        result.add(-1);
        return result;
    }
}
