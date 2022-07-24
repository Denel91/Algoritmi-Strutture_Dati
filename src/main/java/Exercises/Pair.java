package Exercises;

public class Pair {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10, 12};
        int[] b = {1, 0, 5, 11};
        System.out.println(isPair(a, b));
        System.out.println(match(a, b));
    }

    public static boolean isPair(int[] A, int[] B) {
        int k = 0;
        while (k < B.length) {
            for (int i = 0; i < A.length - 1; i++) {
                int j = i + 1;
                if (B[k] > A[i] && B[k] < A[j]) {
                    return true;
                }
            }

            k++;
        }

        return false;
    }

    public static boolean match(int[] A, int[] B) {
        int k = 0;
        int p = 0;
        int q = A.length - 1;
        while (k < B.length) {
            if (p < q) {
                int m = (p + q) / 2;
                if (B[k] < A[m]) {
                    for (int i = 0; i < m; i++) {
                        int j = i + 1;
                        if (B[k] > A[i] && B[k] < A[j]) {
                            return true;
                        }
                    }
                } else {
                    for (int i = m; i < A.length - 1; i++) {
                        int j = i + 1;
                        if (B[k] > A[i] && B[k] < A[j]) {
                            return true;
                        }
                    }
                }
            }

            k++;
        }

        return false;
    }
}

