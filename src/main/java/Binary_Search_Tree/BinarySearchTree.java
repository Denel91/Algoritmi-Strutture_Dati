package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * BinarySearchTree class
 *
 * Class overview:
 *
 * BinarySearchTree(Node n) : Constructor
 * BinarySearchTree() : Default Constructor
 * getRoot() : Node
 * isRoot(Node p) : boolean
 * setRoot(Node root) : void
 * getRandomElement(BinarySearchTree T) : int
 * preorderPrint(Node n) : void
 * preOrderTraversal(Node node) : void
 * inorderPrint(Node n) : void
 * inOrderTraversal(Node node) : void
 * postorderPrint(Node n) : void
 * postOrderTraversal(Node node) : void
 * treeHeight(Node n) : int
 * depth(Node p) : int
 * treeMax(Node x) : Node
 * treeMin(Node x) : Node
 * treeSearch(Node n, int k) : Node
 * findNode(Node n, int k) : Node
 * treeSuccessor(Node x) : Node
 * treePredecessor(Node x) : Node
 * treeInsert(Node z) : void
 * transplant(Node u, Node v) : void
 * delete(Node z) : void
 * clear() : void
 * printTree() : void
 *
 * @version 03/01/2021
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

    public boolean isRoot(Node p) {
        return p == getRoot();
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Estrae una chiave Random nel BinarySearchTree tra quelle inserite
     *
     * @param T un BinarySearchTree
     * @return una chiave casuale presente nel BinarySearchTree
     */
    public int getRandomElement(BinarySearchTree T) {
        ArrayList<Integer> A = new ArrayList<>();
        inOrder(T, A);
        int index = (int) (Math.random() * A.size());
        return A.get(index);
    }

    /**
     * Visita In-Order che memorizza le chiavi nel Vettore A.
     *
     * @param root la radice del BinarySearchTree
     * @param A un ArrayList<Integer>
     */
    private static void inOrderNode(Node root, ArrayList<Integer> A) {
        if (root.getLeft() != null) {
            inOrderNode(root.getLeft(), A);
        }

        A.add(root.getKey());

        if (root.getRight() != null) {
            inOrderNode(root.getRight(), A);
        }
    }

    /**
     * Procedura che realizza effettivamente la visita In-Order
     *
     * @param T un BinarySearchTree
     * @param A un ArrayList<Integer>
     */
    public static void inOrder(BinarySearchTree T, ArrayList<Integer> A) {
        Node x = T.getRoot();
        inOrderNode(x, A);
    }

    // Pre-Order print of a tree
    public void preorderPrint(Node n) {
        if (n != null) {
            System.out.print(n.getKey() + " ");
            preorderPrint(n.getLeft());
            preorderPrint(n.getRight());
        }
    }

    /**
     * Iterative Pre-Order
     *
     * @param node the root of BST
     */
    public void preOrderTraversal(Node node) {
        Stack<Node> s = new Stack<>();
        if (node != null) {
            s.push(node);
        }

        while (!s.isEmpty()) {
            Node c = s.pop();
            System.out.print(c.getKey() + " ");
            if (c.getRight() != null) {
                s.push(c.getRight());
            }
            if (c.getLeft() != null) {
                s.push(c.getLeft());
            }
        }
    }

    // In-Order print of a tree
    public void inorderPrint(Node n) {
        if (n != null) {
            inorderPrint(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorderPrint(n.getRight());
        }
    }

    /**
     * Iterative In-Order
     *
     * @param node the root of BST
     */
    public void inOrderTraversal(Node node) {
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.getLeft();
            } else {
                node = s.pop();
                System.out.print(node.getKey() + " ");
                node = node.getRight();
            }
        }
    }

    // Post-Order print of a tree
    public void postorderPrint(Node n) {
        if (n != null) {
            postorderPrint(n.getLeft());
            postorderPrint(n.getRight());
            System.out.print(n.getKey() + " ");
        }
    }

    /**
     * Iterative Post-Order
     *
     * @param node the root of BST
     */
    public void postOrderTraversal(Node node) {
        Stack<Node> s = new Stack<>();
        Stack<Integer> out = new Stack<>();
        if (node != null) {
            s.push(node);
        }

        while (!s.isEmpty()) {
            Node c = s.pop();
            out.push(c.getKey());

            if (c.getLeft() != null) {
                s.push(c.getLeft());
            }

            if (c.getRight() != null) {
                s.push(c.getRight());
            }
        }

        while (!out.isEmpty()) {
            System.out.print(out.pop() + " ");
        }
    }

    /**
     * Compute the height
     *
     * @param n the root of BST
     * @return the height of binary tree
     */
    public int treeHeight(Node n) {
        if (n.getLeft() == null && n.getRight() == null) {
            return 0;
        } else if (n.getLeft() == null) {
            return 1 + treeHeight(n.getRight());
        } else if (n.getRight() == null) {
            return 1 + treeHeight(n.getLeft());
        } else {
            return 1 + Math.max(treeHeight(n.getLeft()), treeHeight(n.getRight()));
        }
    }

    /**
     * Profondità: Numero di spigoli tra la radice e un nodo
     *
     * @param p un nodo del BinarySearchTree
     * @return la profondità di un BinarySearchTree
     */
    public int depth(Node p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(p.getParent());
    }

    /**
     * Find the Node with max value in a tree
     *
     * @param x the root of BST
     * @return the Node with max value in a tree
     */
    public Node treeMax(Node x) {
        while (x.getRight() != null) {
            x = x.getRight();
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
        if (x.getRight() == null) {
            return x;
        }
        return maxValue(x.getRight());
    }

    /**
     * Find the Node with min value in a tree
     *
     * @param x the root of BST
     * @return the Node with min value in a tree
     */
    public Node treeMin(Node x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
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
        if (x.getLeft() == null) {
            return x;
        }
        return minValue(x.getLeft());
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
        if (n == null || n.getKey() == k) {
            return n;
        }
        return (n.getKey() > k) ? treeSearch(n.getLeft(), k) : treeSearch(n.getRight(), k);
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
        while (n != null && k != n.getKey()) {
            if (n.getKey() > k) {
                n = n.getLeft();
            } else {
                n = n.getRight();
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
    public Node treeSuccessor(Node x) {
        if (x.getRight() != null) {
            return treeMin(x.getRight());
        } else {
            Node y = x.getParent();
            while (y != null && x == y.getRight()) {
                x = y;
                y = y.getParent();
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
        if (x.getLeft() != null) {
            return treeMax(x.getLeft());
        } else {
            Node y = x.getParent();
            while (y != null && x == y.getLeft()) {
                x = y;
                y = y.getParent();
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

    private void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            root = v;
        }
        if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    /**
     * Delete node z from the BST
     *
     * @param z Node to delete from the BST
     */
    public void delete(Node z) {
        // 4 cases
        if (z.getLeft() == null) {  // 1: z has only a right child
            transplant(z, z.getRight());
        } else if (z.getRight() == null) {  // 2: z has only a left child
            transplant(z, z.getLeft());
        } else {
            Node y = treeMin(z.getRight());
            if (y.getParent() != z) {
                transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
    }

    /**
     * Svuota completamente un BinarySearchTree
     */
    public void clear() {
        this.root = null;
    }

    //-------------------------------- TREE PRINTING ------------------------------------

    public void printTree() {
        printSubtree(root);
    }

    public void printSubtree(Node node) {
        if (node.getRight() != null) {
            printTree(node.getRight(), true, "");
        }
        printNodeValue(node);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), false, "");
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
        if (node.getRight() != null) {
            printTree(node.getRight(), true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), false, indent + (isRight ? " |      " : "        "));
        }
    }
}
