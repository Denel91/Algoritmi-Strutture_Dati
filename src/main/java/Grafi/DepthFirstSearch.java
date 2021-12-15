package Grafi;

import java.util.LinkedList;
import java.util.Vector;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Depth-First Search
 *
 * @version 15/12/2021
 */
public class DepthFirstSearch {
    private int vertexCount;                    // numero di vertici nel Grafo
    private LinkedList<Integer> adj[];          // lista di adiacenza
    private Vector<Integer> parent;             // vettore dei predecessori
    private Vector<String> colour;              // vettore dei colori
    private Vector<Integer> discoveredTime;     // tempo di scoperta
    private Vector<Integer> completionTime;     // tempo di completamento
    private int time;                           // registra le informazioni temporali

    /**
     * Default Constructor
     *
     * @param vertexCount numero di vertici del grafo
     */
    public DepthFirstSearch(int vertexCount) {
        this.vertexCount = vertexCount;
        this.parent = new Vector<>();
        this.colour = new Vector<>();
        this.discoveredTime = new Vector<>();
        this.completionTime = new Vector<>();
        parent.setSize(vertexCount);
        colour.setSize(vertexCount);
        discoveredTime.setSize(vertexCount);
        completionTime.setSize(vertexCount);
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++)
             adj[i] = new LinkedList<>();
    }

    /**
     * Collega due nodi in un grafo non orientato
     *
     * @param v nodo del grafo
     * @param w nodo del grafo
     */
    public void addEdge(int v, int w) {
        if (!adj[v].contains(w)) {
            adj[v].add(w);
        }

        if (!adj[w].contains(v)) {
            adj[w].add(v);
        }
    }

    /**
     * Collega due nodi in un grafo orientato
     *
     * @param v nodo del grafo
     * @param w nodo del grafo
     */
    public void addEdgeDirected(int v, int w) {
        if (!adj[v].contains(w)) {
            adj[v].add(w);
        }
    }

    /**
     * Depth-First Search
     */
    public void DFS(int source) {
        for (int i = 0; i < vertexCount; i++) {
            colour.set(i, "white");
            parent.set(i, null);
        }
        time = 0;
        for (int i = source; i < vertexCount; i++) {
            if (colour.get(i).equals("white")) {
                DFS_Visit(i);
            }
        }
    }

    /**
     * Procedura di supporto
     *
     * @param u nodo del grafo visitato in quell'istante
     */
    private void DFS_Visit(int u) {
        System.out.print(u + " ");
        time = time + 1;
        discoveredTime.set(u, time);
        colour.set(u, "gray");
        for (var v : adj[u]) {
            if (colour.get(v).equals("white")) {
                parent.set(v, u);
                DFS_Visit(v);
            }
        }

        colour.set(u, "black");
        time = time + 1;
        completionTime.set(u, time);
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public Vector<Integer> getParent() {
        return parent;
    }

    public Vector<String> getColour() {
        return colour;
    }

    public Vector<Integer> getCompletionTime() {
        return completionTime;
    }

    public Vector<Integer> getDiscoveredTime() {
        return discoveredTime;
    }

    // Transpose the graph
    public DepthFirstSearch transpose() {
        DepthFirstSearch g = new DepthFirstSearch(vertexCount);
        for (int s = 0; s < vertexCount; s++) {
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(s);
            }
        }
        return g;
    }

    @Override
    public String toString() {
        return "" + Arrays.toString(adj) + "";
    }

    public static void main(String[] args) {
        int vertices = 6;
        DepthFirstSearch graph = new DepthFirstSearch(vertices);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        System.out.println("The Depth-First Search of the Graph is:");
        graph.DFS(1); // 1 2 4 5 3

        System.out.println();

        DepthFirstSearch graph_2 = new DepthFirstSearch(6);
        graph_2.addEdgeDirected(1, 2);
        graph_2.addEdgeDirected(2, 3);
        graph_2.addEdgeDirected(3, 1);
        graph_2.addEdgeDirected(1, 4);
        graph_2.addEdgeDirected(1, 5);
        System.out.println("The Depth-First Search of the Graph is:");
        graph_2.DFS(1); // 1 2 3 4 5

        System.out.println();

        System.out.println(graph_2.getParent().toString());
        System.out.println(graph_2.getColour().toString());
        System.out.println(graph_2.getDiscoveredTime().toString());
        System.out.println(graph_2.getCompletionTime().toString());

        System.out.println();

        DepthFirstSearch graph_3 = new DepthFirstSearch(6);
        graph_3.addEdgeDirected(1, 2);
        graph_3.addEdgeDirected(1, 3);
        graph_3.addEdgeDirected(2, 4);
        graph_3.addEdgeDirected(2, 5);
        System.out.println("The Depth-First Search of the Graph is:");
        graph_3.DFS(1); // 1 2 4 5 3
        System.out.println(graph_3.getCompletionTime());

        // Strongly Connected Components example
        DepthFirstSearch g = new DepthFirstSearch(8);
        g.addEdgeDirected(0, 1);
        g.addEdgeDirected(1, 2);
        g.addEdgeDirected(2, 3);
        g.addEdgeDirected(2, 4);
        g.addEdgeDirected(3, 0);
        g.addEdgeDirected(4, 5);
        g.addEdgeDirected(5, 6);
        g.addEdgeDirected(6, 4);
        g.addEdgeDirected(6, 7);

        System.out.println("Graph:");
        System.out.println(g); // [[1], [2], [3, 4], [0], [5], [6], [4, 7], []]
        System.out.println("The Depth-First Search of the Graph is:");
        g.DFS(0); // 0 1 2 3 4 5 6 7
        System.out.println();
        System.out.println(g.getDiscoveredTime()); // [1, 2, 3, 4, 6, 7, 8, 9]
        System.out.println();
        System.out.println(g.getCompletionTime()); // [16, 15, 14, 5, 13, 12, 11, 10]
        System.out.println();
        System.out.println(g.getParent()); // [null, 0, 1, 2, 2, 4, 5, 6]
        System.out.println("Transpose Graph:");
        DepthFirstSearch graph_4 = g.transpose();
        System.out.println(graph_4); // [[3], [0], [1], [2], [2, 6], [4], [5], [6]]
        graph_4.DFS(0); // 0 3 2 1 4 6 5 7
        System.out.println();
        System.out.println(graph_4.getParent()); // [null, 2, 3, 0, null, 6, 4, null]
    }
}
