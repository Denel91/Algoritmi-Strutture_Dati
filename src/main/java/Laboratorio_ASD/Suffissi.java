package Laboratorio_ASD;

import java.util.Scanner;

/**
 * Scrivere un programma che stampi tutti i suffissi di una stringa ricevuta in input.
 */
public class Suffissi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        suffixes(s);
    }

    /**
     * @param message una stringa di testo
     */
    public static void suffixes(String message) {
        int n = message.length();
        for (int i = 0; i < n; i++) {
            System.out.println(message.substring(i));
        }

        System.out.println();
    }
}
