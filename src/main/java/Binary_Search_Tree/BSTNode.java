package Binary_Search_Tree;

//---------------- class BSTNode<E, T> ---------------- //
public class BSTNode<E, T> {
    private E key;                  // the key stored at this node
    private T value;                // the value of the key stored at this node
    private BSTNode<E, T> parent;   // a reference to the parent node
    private BSTNode<E, T> left;     // a reference to the left child
    private BSTNode<E, T> right;    // a reference to the right child

    public BSTNode(E k, T v, BSTNode<E, T> above, BSTNode<E, T> leftChild, BSTNode<E, T> rightChild) {
        this.key = k;
        this.value = v;
        this.parent = above;
        this.left = leftChild;
        this.right = rightChild;
    }

    public BSTNode(E k, T v) {
        this.key = k;
        this.value = v;
    }

    public BSTNode(E k) {
        this.key = k;
    }

    // accessor methods

    public E getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public BSTNode<E, T> getParent() {
        return parent;
    }

    public BSTNode<E, T> getLeft() {
        return left;
    }

    public BSTNode<E, T> getRight() {
        return right;
    }

    // update methods

    public void setKey(E key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(BSTNode<E, T> parent) {
        this.parent = parent;
    }

    public void setLeft(BSTNode<E, T> left) {
        this.left = left;
    }

    public void setRight(BSTNode<E, T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return '(' + "key: " + key + ',' + " value: " + value + ')';
    }
} //----------- End of class BSTNode<E, T> ----------- //


