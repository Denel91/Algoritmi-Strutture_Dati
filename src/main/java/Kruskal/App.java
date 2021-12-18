package Kruskal;

import java.util.HashSet;
import java.util.Set;

/**
 * This application is a Java implementation of Kruskal's Minimum Spanning Tree Algorithm.
 *
 * @author Daniele
 */
public class App {
    Set<HashSet<Vertex>> sets = null;

    /**
     * Create a new set whose only element and representative is x.
     *
     * @param vertex the unique element to add in the sets
     */
    void makeSet(Vertex vertex) {
        if (vertex != null) {
            HashSet<Vertex> newSet = new HashSet<>();
            newSet.add(vertex);
            boolean addNewSet = true;

            if (sets == null) {
                sets = new HashSet<>();
            } else {
                for (HashSet<Vertex> v : sets) {
                    if (newSet.equals(v)) {
                        addNewSet = false;
                    }
                }
            }

            //if the set is unique, add it
            sets.add(newSet);
        }
    }

    /**
     * Returns a pointer to the representative of the (unique) set containing x.
     *
     * @param vertex the vertex we want to find in a set
     * @return the set which contained the vertex
     */
    HashSet<Vertex> findSet(Vertex vertex) {
        HashSet<Vertex> fs = null;
        for (HashSet<Vertex> set : sets) {
            if (set.contains(vertex)) {
                fs = set;
            }
        }

        return fs;
    }

    /**
     * It joins the dynamic sets containing x and y into a new set which is the union of these two sets.
     *
     * @param u a set which contains the vertex u
     * @param v a set which contains the vertex v
     */
    void union(Vertex u, Vertex v) {
        HashSet<Vertex> s1 = findSet(u);
        HashSet<Vertex> s2 = findSet(v);
        assert (s1 != null);
        assert (s2 != null);
        HashSet<Vertex> union = new HashSet<>();
        union.addAll(s1);
        union.addAll(s2);
        sets.remove(s1);
        sets.remove(s2);
        sets.add(union);
    }

    /**
     * Kruskal's Minimum Spanning Tree Algorithm
     *
     * @param G a Graph
     * @return a Minimum Spanning Tree
     */
    public Graph Kruskal(Graph G) {
        Graph A = new Graph();
        for (Vertex v : G.getVertices()) {
            makeSet(v);
        }

        for (Edge edge : G.getEdgesNonDecreasing()) {
            if (findSet(edge.u) != findSet(edge.v)) {
                // add the edge to the MST
                A.add(edge);
                union(edge.u, edge.v);
            }
        }

        return A;
    }

    @Override
    public String toString() {
        return "App: " + sets;
    }

    public static void main(String[] args) {
        App app = new App();
        Graph G = new Graph();
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');
        Vertex i = new Vertex('i');
        G.add(new Edge(a, b, 4));
        G.add(new Edge(b, c, 8));
        G.add(new Edge(c, d, 7));
        G.add(new Edge(d, e, 9));
        G.add(new Edge(e, f, 10));
        G.add(new Edge(f, g, 2));
        G.add(new Edge(g, h, 1));
        G.add(new Edge(h, a, 8));
        G.add(new Edge(i, c, 2));
        G.add(new Edge(c, f, 4));
        G.add(new Edge(i, g, 6));
        G.add(new Edge(i, h, 7));
        G.add(new Edge(b, h, 11));
        G.add(new Edge(d, f, 14));

        Graph A = app.Kruskal(G);
        System.out.println(A); // Graph: [[g,h,1], [i,c,2], [f,g,2], [b,c,8], [c,f,4], [c,d,7], [a,b,4], [d,e,9]]
    }
}
