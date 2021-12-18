package Kruskal;

/**
 * class Edge
 *
 * @author Daniele
 */
public class Edge implements Comparable<Edge> {

    public final Vertex u;      // the character which represents the u point of the edge
    public final Vertex v;      // the character which represents the v point of the edge
    public final int weight;    // the weight of this edge

    /**
     * Construct a new edge
     *
     * @param u the character which represents the u point of the edge
     * @param v the character which represents the v point of the edge
     * @param weight the weight of this edge
     */
    public Edge(Vertex u, Vertex v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    /**
     * Verify if this edge includes the vertex argument
     *
     * @param v the vertex to test
     * @return true if the vertex belong to the edge, false otherwise
     */
    boolean has(Vertex v) {
        return ((this.v.equals(v)) || (this.u.equals(v)));
    }

    /**
     * A comparator to compare the weight of two edges
     *
     * @param e the edge to compare
     * @return 0 if the edges weight are the same,
     * -1 if this edge is less to the parameter e,
     * 1 if this edge is greater than the parameter e
     */
    @Override
    public int compareTo(Edge e) {
        Integer e_1 = this.weight;
        Integer e_2 = e.weight;
        return e_1.compareTo(e_2);
    }

    @Override
    public String toString() {
        return "[" + u + "," + v + "," + weight + "]";
    }

    public static void main(String[] args) {
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Edge edge = new Edge(a, b, 7);
        Edge edge1 = new Edge(c, d, 4);
        System.out.println(edge.has(a));
        System.out.println(edge.has(b));
        System.out.println(edge.compareTo(edge1));
    }
}
