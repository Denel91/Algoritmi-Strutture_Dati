package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Scrivere un programma che riceva in input un array (non necessariamente ordinato) di interi di lunghezza
 * arbitraria n e restituisca in output, se esiste, l'elemento dell'array che occorre almeno ⌊n/2⌋ + 1 volte.
 * Se tale elemento non esiste, l'algoritmo dovrà stampare la stringa "No Majority".
 */
public class ElementoMaggioranza {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        findMajority(vector);
        System.out.println(majorityCandidate(vector));
    }

    // requires an input Scanner object (e.g. in = new Scanner(System.in); )
    public static ArrayList<Integer> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        // convert array of strings into array of integers
        ArrayList<Integer> arr = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
            {
                arr.add(Integer.parseInt(token));
            }
        }

        return arr;
    }

    /**
     * @param A un ArrayList di Interi
     */
    public static void findMajority(ArrayList<Integer> A) {
        int maxCount = 0;
        int candidate = -1;
        int n = A.size();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (Integer integer : A) {
                if (A.get(i).equals(integer)) {
                    count++;
                }
            }

            // aggiorna maxCount se il contatore
            // dell'elemento corrente è maggiore.
            if (count > maxCount) {
                maxCount  = count;
                candidate = i;
            }
        }

        // se maxCount è > di n/2
        // allora ho trovato l'elemento candidato.
        if (maxCount > n / 2) {
            System.out.println(A.get(candidate));

        } else {
            System.out.println("No Majority Element");
        }
    }

    /**
     * @param A un ArrayList di Interi
     * @return il Majority Element nell'ArrayList
     */
    public static int majorityCandidate(ArrayList<Integer> A) {
        int candidate = A.get(0);
        int count = 1; // occorrenze di candidate
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = A.get(i);
                count = 1;
            }
        }

        // Quando esco da questo ciclo la variabile candidate è il candidato

        count = 0;
        for (Integer integer : A) {
            if (integer == candidate) {
                count++;
            }
        }

        if (count > A.size() / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
