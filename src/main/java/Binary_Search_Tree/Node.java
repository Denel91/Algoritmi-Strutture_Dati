package Binary_Search_Tree;

/**
 * Node class for Binary Search Tree (BST)
 */
public class Node {
    Node parent = null;
    Node left = null;
    Node right = null;
    int key;

    // Default Constructor
    public Node(int k) {
        this.key = k;
    }

    // add children

    public void addLeft(Node n) {
        n.parent = this;
        this.left = n;
    }

    public void addRight(Node n) {
        n.parent = this;
        this.right = n;
    }

    // metodi di accesso

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "[" + key + "]";
    }
}
