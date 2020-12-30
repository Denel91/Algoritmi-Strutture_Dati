package Binary_Search_Tree;

//---------------- BinaryTree class ----------------

public class BinaryTree {
    NodeBST root; // root of BST

    // Constructor
    public BinaryTree(NodeBST n) {
        this.root = n;
    }

    // Default Constructor
    public BinaryTree() {
        this.root = null;
    }

    /**
     * @return the root of a BST
     */
    public NodeBST getRoot() {
        return root;
    }

    /**
     * Insert a new Node in the BinarySearchTree
     *
     * @param z the new node to add
     */
    public void treeInsert(NodeBST z) {
        NodeBST y = null;
        NodeBST x = root;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        z.setParent(y);
        if (y == null) {
            root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    /**
     * Versione iterativa
     * Find the Node with key k in a binary tree
     *
     * @param n the root of BST
     * @param k the Key value to find in a binary tree
     * @return the Node with key k in a binary tree
     */
    private NodeBST findNode(NodeBST n, int k) {
        while (n != null && k != n.getKey()) {
            if (n.getKey() > k) {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }
        assert n != null;
        return n;
    }

    /**
     * Svuota completamente un BinarySearchTree
     */
    public void clear() {
        this.root = null;
    }

    /**
     * Trova il Nodo con la chiave K in un BinarySearchTree
     *
     * @param A un array di Interi
     * @return la chiave K
     */
    public int esecuzione(int[] A, int k) {
        BinaryTree T = new BinaryTree();
        for (int i = 0; i < A.length; i++) {
            NodeBST x = new NodeBST(A[i], Integer.toString(A[i]));
            T.treeInsert(x);
        }

        NodeBST y = findNode(T.getRoot(), k);
        return (y != null) ? y.getKey() : -1;
    }

    //---------------- E S E C U Z I O N E ----------------

    public static void main(String[] args) {
        int[] v = {12, 5, 2, 9, 18, 15, 13, 17, 19};
        BinaryTree tree = new BinaryTree();
        int k = 15;
        System.out.println(tree.esecuzione(v, k)); // 15
    }
}
