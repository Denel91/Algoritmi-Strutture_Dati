package Laboratorio_ASD;

public class ElementiUguali {
    public static void main(String[] args) {
        int[] A = {3, 6, 9, 2, 5, 3, 7, 8, 3, 1, 4};
        int sameElement = elementiUguali(A, A.length);
        System.out.println(sameElement); // 3
    }

    /**
     *
     * @param A
     * @param n
     * @return
     */

    // Se ordino il vettore con HeapSort la complessità è O(nlogn)
    public static int elementiUguali(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            while ((j < n)) {
                if (A[i] == A[j]) {
                    count++;
                }

                j++;
            }
        }

        return count;
    }
}
