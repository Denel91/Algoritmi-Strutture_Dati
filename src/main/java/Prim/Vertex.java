package Prim;

/**
 * class Vertex
 *
 * @author Daniele
 */
public class Vertex {
    public final char label;
    private int key;
    private Vertex parent;

    /**
     * To build Vertex, requires a single character label
     *
     * @param label
     */
    public Vertex(char label) {
        this.label = label;
        this.key = Integer.MAX_VALUE;
        this.parent = null;
    }

    public int getKey() {
        return key;
    }

    public Vertex getParent() {
        return parent;
    }

    /**
     * Vertices are compared by their labels
     *
     * @param vertex the vertex to compare with this one
     * @return true if labels are the same, false otherwise
     */
    public boolean equals(Vertex vertex) {
        return (this.label == vertex.label);
    }

    @Override
    public String toString() {
        return "" + label + "";
    }
}
