package Kruskal;

/**
 * class Vertex
 *
 * @author Daniele
 */
public class Vertex {
    public final char label;

    /**
     * To build Vertex, requires a single character label
     *
     * @param label
     */
    public Vertex(char label) {
        this.label = label;
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
