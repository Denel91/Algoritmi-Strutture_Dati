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
            System.out.print(n.key + " ");
            preorderPrint(n.left);
            preorderPrint(n.right);
        }
    }

    // In-Order print of a tree
    public void inorderPrint(Node n) {
        if (n != null) {
            inorderPrint(n.left);
            System.out.print(n.key + " ");
            inorderPrint(n.right);
        }
    }

    // Post-Order print of a tree
    public void postorderPrint(Node n) {
        if (n != null) {
            postorderPrint(n.left);
            postorderPrint(n.right);
            System.out.print(n.key + " ");
        }
    }

    /**
     * Insert a new Node in the BinarySearchTree
     *
     * @param z the new node to add
     */
    public void treeInsert(Node z) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.addLeft(new Node(5));
        root.addRight(new Node(18));
        root.left.addLeft(new Node(2));
        root.left.addRight(new Node(9));
        root.right.addLeft(new Node(15));
        root.right.addRight(new Node(19));
        root.right.left.addRight(new Node(17));

        Node z = new Node(13);
        BinarySearchTree tree = new BinarySearchTree(root);
        tree.treeInsert(z);
        tree.preorderPrint(root); // 12 5 2 9 18 15 13 17 19
    }
}
