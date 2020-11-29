package Laboratorio_ASD;

import java.util.Scanner;

/**
 * Scrivere un programma che riceva in input due interi e restituisca in output la loro somma.
 */
public class IntegerSum {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int firstInteger = myObj.nextInt(); // 5
        int secondInteger = myObj.nextInt(); // 7
        System.out.println("La somma è: " + sum(firstInteger, secondInteger)); // 12
    }

    /**
     * Somma due numeri interi
     *
     * @param a un numero intero
     * @param b un numero intero
     * @return la somma di a e b
     */
    public static int sum(int a, int b) {
        return (a + b);
    }
}
