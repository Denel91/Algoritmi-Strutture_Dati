package Binary_Search_Tree;

/**
 * BinarySearchTree class
 */
public class BinarySearchTree {
    Node root;

    public BinarySearchTree(Node n) {
        this.root = n;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    // Pre-Order print of a tree
    public void preorderPrint(Node n) {
        if (n != null) {
            System.out.println(n.key);
            preorderPrint(n.left);
            preorderPrint(n.right);
        }
    }

    // In-Order print of a tree
    public void inorderPrint(Node n) {
        if (n != null) {
            inorderPrint(n.left);
            System.out.println(n.key);
            inorderPrint(n.right);
        }
    }

    // Post-Order print of a tree
    public void postorderPrint(Node n) {
        if (n != null) {
            postorderPrint(n.left);
            postorderPrint(n.right);
            System.out.println(n.key);
        }
    }
}
