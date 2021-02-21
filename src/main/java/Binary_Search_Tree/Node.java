package Binary_Search_Tree;

/**
 * Node class for Binary Search Tree (BST)
 *
 * @version 21/02/2021
 */
public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private int key;
    private String value;

    // Default Constructor
    public Node(int k) {
        this.key = k;
        this.value = "";
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(int k, String value) {
        this.key = k;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
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

    public String getValue() {
        return value;
    }

    // update methods

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
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
        return "(" + key + ")";
    }
}
