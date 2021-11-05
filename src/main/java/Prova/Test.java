package Prova;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("ciao");
        a.add("hello");
        a.add("simona");
        a.add("ciao");
        a.add("simona");
        a.add("hello");
        a.add("simona");
        a.add("simona");
        a.add("simona");
        a.add("simona");
        System.out.println(a);
        int n = wordsCount(a, "simona");
        System.out.println(n); // 6
    }

    public static int wordsCount(ArrayList<String> words, String target) {
        int counter = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(target))
                counter++;
        }

        return counter;
    }
}
