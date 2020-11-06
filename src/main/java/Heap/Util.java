package Heap;

import java.util.Random;

public class Util {

    public static void fillWithRandomInts(int[] array) {
        Random rnd = new Random();
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = rnd.nextInt(array.length * 4);
        }
    }
}
