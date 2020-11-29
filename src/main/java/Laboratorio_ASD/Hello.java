package Laboratorio_ASD;

/**
 * Scrivere un programma che stampi "Hello World!".
 */
public class Hello {
    private static final String messaggio = "Hello World!";

    public static void main(String[] args) {
        Hello helloWorld = new Hello();
        helloWorld.print(messaggio);
    }

    private void log(String message) {
        System.out.println(message);
    }

    public void print(String msg) {
        log(msg);
    }
}
