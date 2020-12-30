package Binary_Search_Tree;

/**
 * Node class for Binary Search Tree (BST)
 */
public class Node {
    private Node parent = null;
    private Node left = null;
    private Node right = null;
    private int key;

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

    // update methods

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + key + "]";
    }
}
