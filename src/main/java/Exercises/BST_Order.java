package Exercises;

import Binary_Search_Tree.BinarySearchTree;
import Binary_Search_Tree.Node;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Dato un vettore di interi A, ordinarlo sfruttando un Binary Search Tree.
 */
public class BST_Order {
    public static void main(String[] args) {
        int[] v = {12, 5, 2, 9, 18, 15, 13, 17, 19};
        System.out.println(Arrays.toString(v)); // [12, 5, 2, 9, 18, 15, 13, 17, 19]
        sortWithBST(v);
        System.out.println(Arrays.toString(v)); // [2, 5, 9, 12, 13, 15, 17, 18, 19]

        int[] vector = {6, 3, 2, 5, 7, 8};
        sort(vector);
        System.out.println(Arrays.toString(vector)); // [2, 3, 5, 6, 7, 8]

        Node root5 = new Node(8);
        root5.addLeft(new Node(3));
        root5.addRight(new Node(10));
        root5.getRight().addRight(new Node(14));
        root5.getRight().getRight().addLeft(new Node(12));
        root5.getLeft().addLeft(new Node(1));
        root5.getLeft().addRight(new Node(5));
        root5.getLeft().getRight().addLeft(new Node(4));
        root5.getLeft().getRight().addRight(new Node(7));
        BinarySearchTree tree5 = new BinarySearchTree(root5);

        ArrayList<Integer> A = new ArrayList<>();
        inOrder(tree5, A);
        System.out.println(A);
    }

    /**
     * Ordina un Vettore A utilizzando un BinarySearchTree
     *
     * @param A un vettore di Integers.
     */
    public static void sortWithBST(int[] A) {
        // Empty BinarySearchTree
        BinarySearchTree T = new BinarySearchTree();

        for (int j : A) {
            Node x = new Node(j);
            T.treeInsert(x);
        }

        inOrder(T, A);
    }

    // Visita In-Order che memorizza le chiavi nel Vettore A.
    private static int inOrderNode(Node root, int[] A, int pos) {
        if (root.getLeft() != null) {
            pos = inOrderNode(root.getLeft(), A, pos);
        }

        A[pos++] = root.getKey();

        if (root.getRight() != null) {
            pos = inOrderNode(root.getRight(), A, pos);
        }

        return pos;
    }

    public static void inOrder(BinarySearchTree T, int[] A) {
        Node x = T.getRoot();
        inOrderNode(x, A, 0);
    }

    /**
     * Ordina un Vettore A utilizzando un BinarySearchTree
     *
     * @param A un vettore di Integers.
     */
    public static void sort(int[] A) {
        assert A != null : "A non può essere null";
        // Empty BinarySearchTree
        BinarySearchTree T = new BinarySearchTree();
        for (int j : A) {
            Node x = new Node(j);
            T.treeInsert(x);
        }

        sortSuccessor(T, A);
    }

    /**
     * Procedura di supporto che riempie l'array A in ordine
     *
     * @param A un vettore di Integers.
     * @param T un BinarySearchTree
     */
    private static void sortSuccessor(BinarySearchTree T, int[] A) {
        int pos = 0;        // indice iniziale dell'array A
        int n = A.length;   // lunghezza dell'array A
        Node min = T.treeMin(T.getRoot()); // calcolo il minimo
        while (pos < n) {
            A[pos] = min.getKey();
            pos++;
            min = T.treeSuccessor(min); // calcolo il successore del minimo
        }
    }

    /**
     *
     * @param root
     * @param A
     * @return
     */
    private static ArrayList<Integer> inOrderNode(Node root, ArrayList<Integer> A) {
        if (root.getLeft() != null) {
            inOrderNode(root.getLeft(), A);
        }

        if ((root.getKey() % 2) == 0) {
            A.add(root.getKey());
        }

        if (root.getRight() != null) {
            inOrderNode(root.getRight(), A);
        }

        return A;
    }

    /**
     *
     * @param T
     * @param A
     */
    public static void inOrder(BinarySearchTree T, ArrayList<Integer> A) {
        Node x = T.getRoot();
        inOrderNode(x, A);
    }
}
