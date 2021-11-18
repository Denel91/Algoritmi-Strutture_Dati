package Make_Union_Find;

/**
 * class Node
 */
public class Node {
    private int value;

    public Node() {
        this.value = -1;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEqual(Node item) {
        return this.value == item.value;
    }

    public boolean isGreaterThan(Node item) {
        return this.value > item.value;
    }

    public boolean isLessThan(Node item) {
        return this.value < item.value;
    }

    public String stringValue() {
        return "" + this.value;
    }
}
