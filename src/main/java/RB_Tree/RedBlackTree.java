package RB_Tree;

import RB_Tree.RedBlackTree.RBNode.Color;
import Binary_Search_Tree.Node;

import java.util.Stack;

/**
 * RedBlackTree class
 *
 * Class overview:
 *
 * RedBlackTree() : Default Constructor
 * RedBlackTree(RBNode n) : Constructor
 * getRoot() : RBNode
 * isRoot(RBNode p) : boolean
 * create(int key) : RBNode
 * inorderPrint(RBNode n) : void
 * preorderPrint(RBNode n) : void
 * postorderPrint(RBNode n) : void
 * findNode(RBNode n, int k) : RBNode
 * treeSuccessor(RBNode x) : RBNode
 * treePredecessor(RBNode x) : RBNode
 * treeMin(RBNode x) : RBNode
 * treeMax(RBNode x) : RBNode
 * treeHeight(RBNode n) : int
 * treeHeight() : int
 * treeInsert(RBNode node) : void
 * delete(RBNode z) : void
 * isBlack(RBNode node) : boolean
 * isRed(RBNode node) : boolean
 * successorOfK(RBNode node, int k) : RBNode
 * minimumDepth(RBNode root, int level) : int
 * minDist(RedBlackTree T, RBNode root) : int
 * blackPath(RedBlackTree T, RBNode node) : boolean
 * minRed(RBNode node) : int
 * printPositive(RBNode node, Stack<Integer> path) : void
 * clear() : void
 * printTree() : void
 *
 * @version 12/05/2022
 */
public class RedBlackTree {
    RBNode nil;
    RBNode root;
    int bh;

    // Default Constructor
    public RedBlackTree() {
        this.nil = new RBNode(0, Color.BLACK);
        this.root = nil;
        this.bh = 0;
    }

    // Constructor
    public RedBlackTree(RBNode n) {
        this.root = n;
    }

    public RBNode getRoot() {
        return root;
    }

    public boolean isRoot(RBNode p) {
        return p == getRoot();
    }

    public int getBh() {
        return bh;
    }

    public static RBNode create(int key) {
        RBNode x = new RBNode(key);
        x.left = null;
        x.right = null;
        x.parent = null;
        x.color = Color.RED;
        return x;
    }

    // In-order print of a tree
    public void inorderPrint(RBNode n) {
        if (n != nil) {
            inorderPrint(n.left);
            System.out.print(n.key + " ");
            inorderPrint(n.right);
        }
    }

    // Pre-Order print of a tree
    public void preorderPrint(RBNode n) {
        if (n != nil) {
            System.out.print(n.getKey() + " ");
            preorderPrint(n.getLeft());
            preorderPrint(n.getRight());
        }
    }

    // Post-Order print of a tree
    public void postorderPrint(RBNode n) {
        if (n != nil) {
            postorderPrint(n.getLeft());
            postorderPrint(n.getRight());
            System.out.print(n.getKey() + " ");
        }
    }

    /**
     * Versione iterativa
     * Find the Node with key k in the RedBlackTree
     *
     * @param n the root of RedBlackTree
     * @param k the Key value to find in the RedBlackTree
     * @return the Node with key k in RedBlackTree
     */
    public RBNode findNode(RBNode n, int k) {
        while (n != nil && k != n.getKey()) {
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
     * @param x a Node in the RedBlackTree
     * @return the successor of a given Node
     */
    public RBNode treeSuccessor(RBNode x) {
        if (x.getRight() != nil) {
            return treeMin(x.getRight());
        } else {
            RBNode y = x.getParent();
            while (y != nil && x == y.getRight()) {
                x = y;
                y = y.getParent();
            }
            return y;
        }
    }

    /**
     * Find the predecessor of a given node
     *
     * @param x a Node in the RedBlackTree
     * @return the predecessor of a given Node
     */
    public RBNode treePredecessor(RBNode x) {
        if (x.getLeft() != nil) {
            return treeMax(x.getLeft());
        } else {
            RBNode y = x.getParent();
            while (y != nil && x == y.getLeft()) {
                x = y;
                y = y.getParent();
            }
            return y;
        }
    }

    /**
     * Find the Node with min value in a RedBlackTree
     *
     * @param x the root of RedBlackTree
     * @return the Node with min value in a RedBlackTree
     */
    public RBNode treeMin(RBNode x) {
        while (x.getLeft() != nil) {
            x = x.getLeft();
        }
        return x;
    }

    /**
     * Find the Node with max value in a RedBlackTree
     *
     * @param x the root of RedBlackTree
     * @return the Node with max value in a RedBlackTree
     */
    public RBNode treeMax(RBNode x) {
        while (x.getRight() != nil) {
            x = x.getRight();
        }
        return x;
    }

    /**
     * Compute the height
     *
     * @param n the root of RedBlackTree
     * @return the height of RedBlackTree
     */
    public int treeHeight(RBNode n) {
        if (n.left == nil && n.right == nil) {
            return 0;
        } else if (n.left == nil) {
            return 1 + treeHeight(n.right);
        } else if (n.right == nil) {
            return 1 + treeHeight(n.left);
        } else {
            return 1 + Math.max(treeHeight(n.left), treeHeight(n.right));
        }
    }

    public int treeHeight() {
        return treeHeight(root);
    }

    /**
     * Left rotation of a Node
     *
     * @param node a Node in a RedBlackTree
     */
    private void leftRotate(RBNode node) {
        RBNode y = node.right;
        node.right = y.left;
        if (y.left != nil) {
            y.left.parent = node;
        }
        y.parent = node.parent;
        if (node.parent == nil) {
            root = y;
        } else if (node == node.parent.left) {
            node.parent.left = y;
        } else {
            node.parent.right = y;
        }
        y.left = node;
        node.parent = y;
    }

    /**
     * Right rotation of a Node
     *
     * @param node a Node in a RedBlackTree
     */
    private void rightRotate(RBNode node) {
        RBNode y = node.left;
        node.left = y.right;
        if (y.right != nil) {
            y.right.parent = node;
        }
        y.parent = node.parent;
        if (node.parent == nil) {
            root = y;
        } else if (node == node.parent.right) {
            node.parent.right = y;
        } else {
            node.parent.left = y;
        }
        y.right = node;
        node.parent = y;
    }

    /**
     * Insert a new Node in the RedBlackTree
     *
     * @param node the new node to add
     */
    public void treeInsert(RBNode node) {
        RBNode y = nil;
        RBNode x = root;

        while (x != nil) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;  // this covers all cases
        if (y == nil) {   // tree was empty
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
        node.left = nil;
        node.right = nil;
        node.color = Color.RED;
        insertFixup(node);
    }

    /**
     * Fix up the tree that just had node inserted
     *
     * @param z a Node in a RedBlackTree
     */
    private void insertFixup(RBNode z) {
        while (z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                RBNode y = z.parent.parent.right;       // the "uncle" in CLRS
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;       // CASO 1
                    y.color = Color.BLACK;              // CASO 1
                    z.parent.parent.color = Color.RED;  // CASO 1
                    z = z.parent.parent;                // CASO 1
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;                   // CASO 2
                        leftRotate(z);                  // CASO 2
                    }
                    z.parent.color = Color.BLACK;       // CASO 3
                    z.parent.parent.color = Color.RED;  // CASO 3
                    rightRotate(z.parent.parent);       // CASO 3
                }
            } else {
                RBNode y = z.parent.parent.left;        // the "uncle" in CLRS
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private void transplant(RBNode u, RBNode v) {
        if (u.parent == nil) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    /**
     * Delete node z from the RedBlackTree
     *
     * @param z Node to delete from the RedBlackTree
     */
    public void delete(RBNode z) {
        RBNode y = z;
        Color yOrigColor = y.color;
        RBNode x;
        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMin(z.right);
            yOrigColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOrigColor == Color.BLACK) {
            deleteFixup(x);
        }
    }

    private void deleteFixup(RBNode x) {
        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                RBNode w = x.parent.right;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                } else {
                    if (w.right.color == Color.BLACK) {
                        w.left.color = Color.BLACK;
                        w.color = Color.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                RBNode w = x.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                } else {
                    if (w.left.color == Color.BLACK) {
                        w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    public boolean isBlack(RBNode node) {
        return node == nil || node.color == Color.BLACK;
    }

    public boolean isRed(RBNode node) {
        return node == nil || node.color == Color.RED;
    }

    /**
     * @param node
     * @param k    un valore intero
     * @return la più piccola chiave più grande di K (successore di k)
     */
    public RBNode successorOfK(RBNode node, int k) {
        if (node.getKey() == k) {
            return node;

        } else if (node.getKey() > k) {
            return treeMax(node.getLeft());

        } else {
            return treeMax(node.getRight());
        }
    }

    /**
     * Find Minimum Depth of a RedBlack Tree
     *
     * @param root  the root of the tree
     * @param level the first level of the tree
     * @return
     */
    public int minimumDepth(RBNode root, int level) {
        if (root == nil) {
            return level;
        }
        level++;
        return Math.min(minimumDepth(root.getLeft(), level), minimumDepth(root.getRight(), level));
    }

    /**
     * Returns the minimum distance between two nodes
     *
     * @param T
     * @param root
     * @return
     */
    public int minDist(RedBlackTree T, RBNode root) {
        RBNode u = T.treeMin(root);
        RBNode prev = nil;
        int min = Integer.MAX_VALUE;
        while (u != nil) {
            if (u.getKey() - prev.getKey() < min) {
                min = u.getKey() - prev.getKey();
            }

            prev = u;
            u = T.treeSuccessor(u);
        }

        return min;
    }

    /**
     * @param T
     * @param node
     * @return
     */
    public boolean blackPath(RedBlackTree T, RBNode node) {
        if (node == nil) {
            return true;
        }

        if (node.color == Color.BLACK) {
            return blackPath(T, node.getLeft()) || blackPath(T, node.getRight());
        }

        return false;
    }

    /**
     * Return the minimum distance of a red node from root node
     *
     * @param node
     * @return
     */
    public int minRed(RBNode node) {
        if (node == nil) {
            return 0;
        }

        if (isRed(node.left) && isRed(node.right)) {
            return 1;
        }

        if ((isRed(node.left) && isBlack(node.right)) || (isBlack(node.left) && isRed(node.right))) {
            return 1;
        }

        if (isBlack(node.left) && isBlack(node.right)) {
            return 1 + Math.min(minRed(node.left), minRed(node.right));
        }

        return 0;
    }

    /**
     * Stampa i valori di tutti i percorsi radice-foglia composti da soli
     * valori positivi.
     *
     * @param node
     * @return
     */
    public void printPositive(RBNode node, Stack<Integer> path) {
        if (node != nil && node.getKey() > 0) {
            path.push(node.getKey());
            if (node.getLeft() == nil && node.getRight() == nil) {
                System.out.println(path);
            } else {
                printPositive(node.getLeft(), path);
                printPositive(node.getRight(), path);
            }

            path.pop();
        }
    }

    /**
     * Delete nodes greater than k
     *
     * @param node
     * @param k
     */
    public void removeFromK(RBNode node,  int k) {
        if (node != nil){
            RBNode u = findNode(node, k);
            while (u.getKey() >= k) {
                RBNode maxNode = treeMax(u);
                u = maxNode.getParent();
                delete(maxNode);
            }
        }
    }

    /**
     * Cancella un RedBlackTree
     */
    public void clear() {
        this.root = nil;
    }

    //-------------------------------- TREE PRINTING ------------------------------------

    public void printTree() {
        printSubtree(root);
    }

    public void printSubtree(RBNode node) {
        if (node.getRight() != nil) {
            printTree(node.getRight(), true, "");
        }
        printNodeValue(node);
        if (node.getLeft() != nil) {
            printTree(node.getLeft(), false, "");
        }
    }

    private void printNodeValue(RBNode node) {
        if (node == nil) {
            System.out.print("<null>");
        } else {
            System.out.print(node.getKey());
        }
        System.out.println();
    }

    private void printTree(RBNode node, boolean isRight, String indent) {
        if (node.getRight() != nil) {
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
        if (node.getLeft() != nil) {
            printTree(node.getLeft(), false, indent + (isRight ? " |      " : "        "));
        }
    }

    //---------- Inner class Node for RedBlackTree ----------//

    public static class RBNode {

        enum Color {RED, BLACK}

        int key;
        String value;
        RBNode parent;
        RBNode left;
        RBNode right;
        Color color;

        public RBNode(int k, Color c) {
            this.key = k;
            this.color = c;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public RBNode(int k) {
            this.key = k;
            this.color = Color.RED;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public RBNode(int k, String value) {
            this.key = k;
            this.value = value;
            this.color = Color.RED;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public RBNode(int k, String value, Color c) {
            this.key = k;
            this.value = value;
            this.color = c;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        // constructor for conversion of existing node
        public RBNode(Node n) {
            this.key = n.getKey();
            this.color = Color.RED;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public String getColor() {
            if (color == Color.RED) {
                return "RED";
            } else {
                return "BLACK";
            }
        }

        public int getKey() {
            return key;
        }

        public RBNode getParent() {
            return parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public RBNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "[" + key + "]";
        }
    }
    //---------- End of class Node for RedBlackTree ----------//

    //---------- EXECUTION ----------//
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.treeInsert(new RBNode(26));
        tree.treeInsert(new RBNode(17));
        tree.treeInsert(new RBNode(41));
        tree.treeInsert(new RBNode(14));
        tree.treeInsert(new RBNode(21));
        tree.treeInsert(new RBNode(30));
        tree.treeInsert(new RBNode(47));

        System.out.println(tree.getRoot()); // [26]
        System.out.println(tree.treeHeight()); // 2
        RBNode min = tree.treeMin(tree.getRoot()); // 26
        System.out.println(min.getKey()); // 14
        System.out.println(min.getColor()); // RED
        tree.inorderPrint(tree.getRoot()); // 14 17 21 26 30 41 47
        System.out.println();
        RBNode successor = tree.treeSuccessor(tree.getRoot().getLeft().getRight());
        System.out.println(successor.getKey()); // 26
        RBNode predecessor = tree.treePredecessor(tree.getRoot().getLeft().getRight());
        System.out.println(predecessor.getKey()); // 17
        System.out.println();
        tree.printTree();
        System.out.println();
        tree.delete(tree.root.right);
        RBNode z = create(41);
        tree.treeInsert(z);
        tree.printTree();

        System.out.println();

        RedBlackTree T = new RedBlackTree();
        T.treeInsert(new RBNode(5));
        T.treeInsert(new RBNode(7));
        T.treeInsert(new RBNode(9));
        T.printTree();

        System.out.println();

        RedBlackTree RB = new RedBlackTree();
        RB.treeInsert(new RBNode(41));
        RB.treeInsert(new RBNode(38));
        RB.treeInsert(new RBNode(31));
        RB.treeInsert(new RBNode(12));
        RB.treeInsert(new RBNode(19));
        RB.treeInsert(new RBNode(8));
        RB.printTree();

        System.out.println("Height: " + RB.treeHeight()); // 3
        RBNode successor_1 = RB.treeSuccessor(RB.getRoot().getLeft().getRight());
        System.out.println(successor_1.getKey()); // 38
        int k = 30;
        RBNode smallerKsuccessor = RB.successorOfK(RB.getRoot(), k);
        System.out.println("Successor of K: " + smallerKsuccessor.getKey());
        int minimumDepth = RB.minimumDepth(RB.root, 0);
        System.out.println("The minimum depth is: " + minimumDepth);
        System.out.println(RB.blackPath(RB, RB.getRoot()));
        System.out.println("MinRed: " + RB.minRed(RB.getRoot()));

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.treeInsert(new RBNode(40));
        redBlackTree.treeInsert(new RBNode(38));
        redBlackTree.treeInsert(new RBNode(45));
        redBlackTree.treeInsert(new RBNode(35));
        redBlackTree.printTree();

        System.out.println("Min Distance: " + redBlackTree.minDist(redBlackTree, redBlackTree.getRoot()));
        System.out.println("MinRed: " + redBlackTree.minRed(redBlackTree.getRoot()));

        System.out.println();

        RedBlackTree blackTree = new RedBlackTree();
        blackTree.treeInsert(new RBNode(13));
        blackTree.treeInsert(new RBNode(-1));
        blackTree.treeInsert(new RBNode(-2));
        blackTree.treeInsert(new RBNode(25));
        blackTree.treeInsert(new RBNode(11));
        blackTree.treeInsert(new RBNode(19));
        blackTree.treeInsert(new RBNode(28));
        blackTree.treeInsert(new RBNode(5));
        blackTree.treeInsert(new RBNode(21));
        blackTree.treeInsert(new RBNode(27));
        blackTree.printTree();
        System.out.println();
        blackTree.removeFromK(blackTree.getRoot(), 25);
        blackTree.printTree();

        Stack<Integer> path = new Stack<>();
        blackTree.printPositive(blackTree.getRoot(), path); // [13, 25, 19, 21] [13, 25, 28, 27]

        System.out.println();

        RedBlackTree tree1 = new RedBlackTree();
        tree1.treeInsert(new RBNode(8));
        tree1.treeInsert(new RBNode(4));
        tree1.treeInsert(new RBNode(10));
        tree1.treeInsert(new RBNode(11));
        tree1.treeInsert(new RBNode(9));
        tree1.treeInsert(new RBNode(3));
        tree1.treeInsert(new RBNode(5));
        tree1.printTree();
        System.out.println();
        //tree1.removeFromK(tree1.getRoot(), 10);
        //tree1.printTree();
        //tree1.delete(tree1.getRoot().getRight());
    }
}
