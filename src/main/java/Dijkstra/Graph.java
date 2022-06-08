package Dijkstra;

import java.util.TreeMap;
import java.util.Arrays;
import java.util.*;
/**
 * class Graph
 */
public class Graph {
    private int V; // numero di vertici
    private int E; // numero di archi
    private TreeMap<Integer, Integer>[] adj; // lista di adiacenza

    public Graph(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adj = new TreeMap[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new TreeMap<>();
        }
    }

    public void validateVertex(int u){
        if(u < 0 || u >= getV())
            throw new IllegalArgumentException("Vertex " + u + " is invalid");
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].keySet();
    }

    public void addEdge(int u, int v, int w){
        validateVertex(u);
        validateVertex(v);
        if(u == v) throw new IllegalArgumentException("Self Loop is Detected!");
        adj[u].put(v, w);
        this.E++;
    }

    public void addEdgeReverse(int u, int v, int w){
        validateVertex(u);
        validateVertex(v);
        if(u == v) throw new IllegalArgumentException("Self Loop is Detected!");
        adj[v].put(u, w);
        this.E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public TreeMap<Integer, Integer>[] getAdj() {
        return adj;
    }

    public boolean hasEdge(int u, int v){
        validateVertex(u);
        validateVertex(v);
        return adj[u].containsKey(v);
    }

    public int getWeight(int u,int v){
        if(hasEdge(u,v))
            return adj[u].get(v);
        throw new IllegalArgumentException(String.format("No edge %d %d",u,v));
    }

    @Override
    public String toString() {
        return "Graph: " + Arrays.toString(adj) + "";
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 0, 8);
        graph.addEdge(8, 2, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(8, 6, 6);
        graph.addEdge(8, 7, 7);
        graph.addEdge(1, 7, 11);
        graph.addEdge(3, 5, 14);
        System.out.println(graph);
        System.out.println(graph.adj(3).toString()); // [2, 4, 5]
        System.out.println(graph.getE()); // 14
        System.out.println(graph.getV()); // 9
        System.out.println(graph.getWeight(0, 1)); // 4
    }
}
