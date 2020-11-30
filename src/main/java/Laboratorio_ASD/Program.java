package Laboratorio_ASD;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
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

    public static int binarySearch(ArrayList<Integer> lista, int key, int low, int high) {
        if (high < low) {
            return -1;
        }

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == lista.get(middle)) {
                return middle;
            }
            if (key < lista.get(middle)) {
                // If key is smaller than middle, then it can only be present in left sub-array
                high = middle - 1;
            } else {
                // Else the key can only be present in right sub-array
                low = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Integer> vector = scanArray(myObj);
        int key = myObj.nextInt();
        int low = 0;
        int high = vector.size() - 1;
        System.out.println(binarySearch(vector, key, low, high));
    }
}
