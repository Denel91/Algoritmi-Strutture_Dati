package Binary_Search_Tree;

/**
 * BinarySearchTree class
 *
 * Class overview:
 *
 * BinarySearchTree(Node n) : Constructor
 * BinarySearchTree() : Default Constructor
 * getRoot() : Node
 * preorderPrint(Node n) : void
 * inorderPrint(Node n) : void
 * postorderPrint(Node n) : void
 * treeHeight(Node n) : int
 * treeMax(Node x) : Node
 * treeMin(Node x) : Node
 * treeSearch(Node n, int k) : Node
 * findNode(Node n, int k) : Node
 * treeSucessor(Node x) : Node
 * treePredecessor(Node x) : Node
 * treeInsert(Node z) : void
 * transplant(Node u, Node v) : void
 * delete(Node z) : void
 *
 * @version 24/12/2020
 */
public class BinarySearchTree {
    Node root;

    public BinarySearchTree(Node n) {
        this.root = n;
    }

    // Default Constructor
    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
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
     * Compute the height
     *
     * @param n the root of BST
     * @return the height of binary tree
     */
    public int treeHeight(Node n) {
        if (n.left == null && n.right == null) {
            return 0;
        } else if (n.left == null) {
            return 1 + treeHeight(n.right);
        } else if (n.right == null) {
            return 1 + treeHeight(n.left);
        } else {
            return 1 + Math.max(treeHeight(n.left), treeHeight(n.right));
        }
    }

    /**
     * Find the Node with max value in a tree
     *
     * @param x the root of BST
     * @return the Node with max value in a tree
     */
    public Node treeMax(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * Versione ricorsiva
     * Find the Node with max value in a tree
     *
     * @param x the root of BST
     * @return the Node with max value in a tree
     */
    public Node maxValue(Node x) {
        if (x.right == null) {
            return x;
        }
        return maxValue(x.right);
    }

    /**
     * Find the Node with min value in a tree
     *
     * @param x the root of BST
     * @return the Node with min value in a tree
     */
    public Node treeMin(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Versione ricorsiva
     * Find the Node with min value in a tree
     *
     * @param x the root of BST
     * @return the Node with min value in a tree
     */
    public Node minValue(Node x) {
        if (x.left == null) {
            return x;
        }
        return minValue(x.left);
    }

    /**
     * Versione ricorsiva
     * Find the Node with key k in a binary tree
     *
     * @param n the root of BST
     * @param k the Key value to find in a binary tree
     * @return the Node with key k in a binary tree
     */
    public Node treeSearch(Node n, int k) {
        if (n == null || n.key == k) {
            return n;
        }
        return (n.key > k) ? treeSearch(n.left, k) : treeSearch(n.right, k);
    }

    /**
     * Versione iterativa
     * Find the Node with key k in a binary tree
     *
     * @param n the root of BST
     * @param k the Key value to find in a binary tree
     * @return the Node with key k in a binary tree
     */
    public Node findNode(Node n, int k) {
        while (n != null && k != n.key) {
            if (n.key > k) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }

    /**
     * Find the successor of a given node
     *
     * @param x a Node in the binary tree
     * @return the successor of a given Node
     */
    public Node treeSucessor(Node x) {
        if (x.right != null) {
            return treeMin(x.right);
        } else {
            Node y = x.parent;
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }

    /**
     * Find the predecessor of a given node
     *
     * @param x a Node in the binary tree
     * @return the predecessor of a given Node
     */
    public Node treePredecessor(Node x) {
        if (x.left != null) {
            return treeMax(x.left);
        } else {
            Node y = x.parent;
            while (y != null && x == y.left) {
                x = y;
                y = y.parent;
            }
            return y;
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

    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        }
        if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    /**
     * Delete node z from the BST
     *
     * @param z Node to delete from the BST
     */
    public void delete(Node z) {
        // 4 cases
        if (z.left == null) {  // 1: z has only a right child
            transplant(z, z.right);
        } else if (z.right == null) {  // 2: z has only a left child
            transplant(z, z.left);
        } else {
            Node y = treeMin(z.right);
            if (y.parent != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    //-------------------------------- TREE PRINTING ------------------------------------

    public void printTree() {
        printSubtree(root);
    }

    public void printSubtree(Node node) {
        if (node.right != null) {
            printTree(node.right, true, "");
        }
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, "");
        }
    }

    private void printNodeValue(Node node) {
        if (node == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.getKey());
        }
        System.out.println();
    }

    private void printTree(Node node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }
}
