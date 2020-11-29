package Laboratorio_ASD;

import java.util.Scanner;

/**
 * Scrivere un programma che stampi tutti i prefissi di una stringa ricevuta in input.
 */
public class Prefissi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        prefixes(s);
    }

    /**
     * @param message una stringa di testo
     */
    public static void prefixes(String message) {
        int n = message.length();
        System.out.println(message);
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(message.substring(0, i));
        }

        System.out.println();
    }
}
