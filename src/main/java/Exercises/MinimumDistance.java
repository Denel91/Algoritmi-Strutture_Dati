package Exercises;

public class MinimumDistance {
    public static void main(String[] args) {
        int[] vector = {3, 5, 4, 2, 6, 8, 7, 1, 9};
        int n = vector.length;
        System.out.println(minDist(vector, n, 5, 8));
    }

    /**
     * Complessità: O(n)
     *
     * @param A
     * @param n
     * @param x
     * @param y
     * @return
     */
    public static int minDist(int[] A, int n, int x, int y) {
        int id_x = -1;
        int id_y = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] == x) {
                id_x = i;
            } else if (A[i] == y) {
                id_y = i;
            }
        }

        if (id_x != -1 && id_y != -1) {
            minDist = Math.min(minDist, Math.abs(id_x - id_y));
        }

        return minDist;
    }
}
