package Binary_Search_Tree;

//---------------- Node class ----------------

/**
 *  NodeBST class
 *
 *  Class overview:
 *  NodeBST(int k, String v, NodeBST above, NodeBST leftChild, NodeBST rightChild) : Constructor
 *  NodeBST(int k, String v) : Default Constructor
 *  getKey() : int
 *  getValue() : String
 *  getParent() : NodeBST
 *  getLeft() : NodeBST
 *  getRight() : NodeBST
 *  setKey(int key) : void
 *  setValue(String value) : void
 *  setParent(NodeBST parent) : void
 *  setLeft(NodeBST left) : void
 *  setRight(NodeBST right) : void
 *  toString() : String
 *
 * @version 30/12/2020
 */
public class NodeBST {
    private int key;            // the key stored at this node
    private String value;       // the value of the key stored at this node
    private NodeBST parent;     // a reference to the parent node
    private NodeBST left;       // a reference to the left child
    private NodeBST right;      // a reference to the right child

    public NodeBST(int k, String v, NodeBST above, NodeBST leftChild, NodeBST rightChild) {
        this.key = k;
        this.value = v;
        this.parent = above;
        this.left = leftChild;
        this.right = rightChild;
    }

    // Default Constructor
    public NodeBST(int k, String v) {
        this.key = k;
        this.value = v;
    }

    // accessor methods

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public NodeBST getParent() {
        return parent;
    }

    public NodeBST getLeft() {
        return left;
    }

    public NodeBST getRight() {
        return right;
    }

    // update methods

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setParent(NodeBST parent) {
        this.parent = parent;
    }

    public void setLeft(NodeBST left) {
        this.left = left;
    }

    public void setRight(NodeBST right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return '(' + "key: " + key + ',' + " value: " + value + ')';
    }
} //----------- end of Node class -----------
