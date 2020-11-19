package Exercises;

/**
 * Majority Candidate class
 */
public class MajorityCandidate {
    public static void main(String[] args) {
        int[] vector = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        findMajority(vector); // 4

        int[] array = {3, 3, 4, 2, 4, 4, 2, 4};
        findMajority(array); // No Majority Element
    }

    /**
     * @param A un array di Interi
     */
    public static void findMajority(int[] A) {
        int maxCount = 0;
        int candidate = -1;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }

            // aggiorna maxCount se il contatore
            // dell'elemento corrente è maggiore.
            if (count > maxCount) {
                maxCount  = count;
                candidate = i;
            }
        }

        // se maxCount è > di n/2
        // allora ho trovato l'elemento candidato.
        if (maxCount > n / 2) {
            System.out.println(A[candidate]);

        } else {
            System.out.println("No Majority Element");
        }
    }
}
