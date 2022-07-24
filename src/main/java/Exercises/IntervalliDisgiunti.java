package Exercises;

import java.util.ArrayList;

public class IntervalliDisgiunti {
    public static void main(String[] args) {
        ArrayList<Node> A = new ArrayList<>();
        Node a = new Node(1, 5);
        Node b = new Node(6, 8);
        Node c = new Node(10, 12);
        Node d = new Node(14, 16);
        A.add(a);
        A.add(b);
        A.add(c);
        A.add(d);
        System.out.println(A);
        System.out.println(due_Intervalli_Disgiunti(A));
        ArrayList<Node> B = new ArrayList<>();
        intervalliDisgiunti(A, B, 3);
        System.out.println("B: " + B);

        ArrayList<Node> C = new ArrayList<>();
        Node e = new Node(1, 5);
        Node f = new Node(2, 8);
        C.add(e);
        C.add(f);
        System.out.println(C);
        System.out.println(due_Intervalli_Disgiunti(C));
    }

    /**
     *
     * @param V
     * @param B
     * @param k
     * @return
     */
    public static ArrayList<Node> intervalliDisgiunti(ArrayList<Node> V, ArrayList<Node> B, int k) {
        int p = 0;
        int q = V.size() - 1;
        int m = (p + q) / 2;
        if (k < V.get(m).r) {
            for (int i = 0; i < m; i++) {
                if (V.get(i).r <= V.get(i + 1).l) { // i due intervalli sono disgiunti
                    if (V.get(i).l <= k && k <= V.get(i).r) {
                        B.add(V.get(i));
                    }

                }
            }
        } else if (k > V.get(m).l) {
            for (int i = m + 1; i < V.size() - 1; i++) {
                if (V.get(i).r <= V.get(i + 1).l) { // i due intervalli sono disgiunti
                    if (V.get(i).l <= k && k <= V.get(i).r) {
                        B.add(V.get(i));
                    }
                }
            }
        }

        return B;
    }

    /**
     *
     * @param A
     * @return
     */
    public static boolean due_Intervalli_Disgiunti(ArrayList<Node> A) {
        int min_l = A.get(0).r;
        int max_r = A.get(0).l;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).r < min_l) {
                min_l = A.get(i).r;
            }
            if (A.get(i).l > max_r) {
                max_r = A.get(i).l;
            }
        }

        if (min_l < max_r) {
            return true;
        } else {
            return false;
        }
    }

    public static class Node {
        int l; // lower
        int r; // upper

        public Node() {
            this.l = 0;
            this.r = 0;
        }

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            return "[" + l + "," + r + "]";
        }
    }
}


