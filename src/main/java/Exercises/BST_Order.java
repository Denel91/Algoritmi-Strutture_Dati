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
    }

    /**
     * Ordina un Vettore A utilizzando un BinarySearchTree
     *
     * @param A un vettore di Integers.
     */
    public static void sortWithBST(int[] A) {
        // Empty BinarySearchTree
        BinarySearchTree T = new BinarySearchTree();

        for (int i = 0; i < A.length; i++) {
            Node x = new Node(A[i]);
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
}
