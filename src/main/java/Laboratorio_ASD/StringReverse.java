package Laboratorio_ASD;

import java.util.Scanner;

/**
 * Scrivere un programma che riceva su una riga di input una stringa (con possibili spazi)
 * e in output produca la stessa stringa in ordine inverso.
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverse(s).toString());
    }

    /**
     * Inverte una stringa
     *
     * @param message una stringa di testo
     * @return il messaggio in ordine inverso
     */
    public static StringBuilder reverse(String message) {
        StringBuilder builder = new StringBuilder(message);
        return builder.reverse();
    }
}
