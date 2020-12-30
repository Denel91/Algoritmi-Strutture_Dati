package Exercises;

import Binary_Search_Tree.BinarySearchTree;
import Binary_Search_Tree.Node;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(vector));
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
}
