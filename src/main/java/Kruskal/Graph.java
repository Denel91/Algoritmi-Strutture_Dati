package Kruskal;

import java.util.*;
import java.util.PriorityQueue;

/**
 * class Graph
 *
 * @author Daniele
 */
public class Graph {
    private List<Edge> edges;

    /**
     * Constructor
     */
    public Graph() {
        this.edges = new ArrayList<>();
    }

    /**
     * Add an edge to the Graph
     *
     * @param edge to add to the Graph
     */
    public void add(Edge edge) {
        edges.add(edge);
    }

    /**
     * Does this Graph contains a particular vertex?
     *
     * @param vertex the vertex to query for
     * @return true if the Graph contains the vertex, false otherwise
     */
    public boolean has(Vertex vertex) {
        boolean has = false;
        for (Edge edge : edges) {
            if (edge.has(vertex)) {
                has = true;
            }
        }

        return has;
    }

    /**
     * Total weight of the Graph
     *
     * @return the total weight of the Graph
     */
    public int getWeight() {
        int weight = 0;
        for (Edge edge : edges) {
            weight += edge.weight;
        }

        return weight;
    }

    /**
     * Returns all the vertices in the Graph
     *
     * @return all the vertices in the Graph
     */
    Set<Vertex> getVertices() {
        Set<Vertex> vertices = null;
        if (edges != null) {
            vertices = new HashSet<>();
            for (Edge edge : edges) {
                vertices.add(edge.u);
                vertices.add(edge.v);
            }
        }
        return vertices;
    }

    /**
     * Sorts the edges in a non-decreasing sense with respect to weight
     *
     * @return
     */
    Queue<Edge> getEdgesNonDecreasing() {
        Queue<Edge> edges = new PriorityQueue<>();
        for (Edge edge : this.edges) {
            edges.add(edge);
        }

        return edges;
    }

    @Override
    public String toString() {
        return "Graph: " + edges + "";
    }

    public static void main(String[] args) {
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');
        Edge edge = new Edge(a, b, 7);
        Edge edge_1 = new Edge(c, d, 5);
        Edge edge_2 = new Edge(e, f, 8);
        Edge edge_3 = new Edge(g, h, 3);
        Graph graph = new Graph();
        graph.add(edge);
        graph.add(edge_1);
        graph.add(edge_2);
        graph.add(edge_3);
        System.out.println(graph); // Graph: [[a,b,7], [c,d,5], [e,f,8], [g,h,3]]
        System.out.println(graph.getEdgesNonDecreasing()); // [[g,h,3], [c,d,5], [e,f,8], [a,b,7]]
        System.out.println(graph.getVertices()); // [e, b, f, d, g, a, c, h]
    }
}
