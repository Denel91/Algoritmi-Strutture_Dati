package Prim;

public class Edge {
    public final Vertex u;    // the character which represents the u point of the edge
    public final Vertex v;    // the character which represents the v point of the edge
    public final int weight;  // the weight of this edge

    public Edge(Vertex u, Vertex v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    boolean has(Vertex v) {
        return ((this.v.equals(v)) || (this.u.equals(v)));
    }

    public Vertex getU() {
        return u;
    }

    public Vertex getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge: [" + u + ", " + v + ", " + weight + "]";
    }

    public static void main(String[] args) {
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Edge edge = new Prim.Edge(a,b,4);
        System.out.println(edge); // Edge: [a, b, 4]
    }
}
