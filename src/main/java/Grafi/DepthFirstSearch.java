package Grafi;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Depth-First Search
 *
 * @version 12/10/21
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

    public void addEdge(int v, int w) {
        if (!adj[v].contains(w)) {
            adj[v].add(w);
        }

        if (!adj[w].contains(v)) {
            adj[w].add(v);
        }
    }

    /**
     * Depth-First Search
     */
    public void DFS() {
        for (int i = 0; i < vertexCount; i++) {
            colour.set(i, "white");
            parent.set(i, null);
        }
        time = 0;
        for (int i = 0; i < vertexCount; i++)
            if (colour.get(i).equals("white")) {
                DFS_Visit(i);
            }
    }

    /**
     * Procedura di supporto
     *
     * @param u nodo del grafo scoperto
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

    public static void main(String[] args) {
        int vertices = 6;
        DepthFirstSearch graph = new DepthFirstSearch(vertices);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        System.out.println("The Depth-First Search of the Graph is:");
        graph.DFS(); // 0 1 2 4 5 3
    }
}
