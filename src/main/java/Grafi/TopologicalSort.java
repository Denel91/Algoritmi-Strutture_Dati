package Grafi;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Topological-Sort:
 *
 * Ordinamento lineare di tutti i vertici di un grafo
 * aciclico diretto (DAG, directed acyclic graph).
 *
 * @version 21/10/2021
 */
public class TopologicalSort {
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
    public TopologicalSort(int vertexCount) {
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
     * Ordinamento Topologico:
     * Ordinamento lineare di tutti i vertici di un grafo aciclico diretto
     *
     * @param source nodo di partenza
     * @return una lista ordinata dei nodi del grafo
     */
    public LinkedList<Integer> topologicalSort(int source) {
        for (int i = 0; i < vertexCount; i++) {
            colour.set(i, "white");
            parent.set(i, null);
        }
        time = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = source; i < vertexCount; i++) {
            if (colour.get(i).equals("white")) {
                DFS_VisitTopological(i, list);
            }
        }

        return list;
    }

    /**
     * Procedura di supporto che esegue effettivamente la visita del nodo
     *
     * @param u nodo esaminato in un certo istante
     * @param list lista dei nodi del grafo
     * @return una lista ordinata dei nodi del grafo
     */
    private LinkedList<Integer> DFS_VisitTopological(int u, LinkedList<Integer> list) {
        time = time + 1;
        discoveredTime.set(u, time);
        colour.set(u, "gray");
        for (var v : adj[u]) {
            if (colour.get(v).equals("white")) {
                parent.set(v, u);
                DFS_VisitTopological(v, list);
            }
        }

        colour.set(u, "black");
        time = time + 1;
        completionTime.set(u, time);
        list.addFirst(u);

        return list;
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

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdgeDirected(1, 2);
        graph.addEdgeDirected(1, 3);
        graph.addEdgeDirected(2, 4);
        graph.addEdgeDirected(2, 5);
        System.out.println("Topological-Sort of the Graph is:");
        LinkedList<Integer> list = graph.topologicalSort(1);
        System.out.println(list); // [1, 3, 2, 5, 4]
        System.out.println(graph.getDiscoveredTime().toString()); // [1, 2, 8, 3, 5]
        System.out.println(graph.getCompletionTime().toString()); // [10, 7, 9, 4, 6]

        System.out.println();

        TopologicalSort graph_2 = new TopologicalSort(6);
        graph_2.addEdgeDirected(1, 3);
        graph_2.addEdgeDirected(3, 5);
        graph_2.addEdgeDirected(1, 2);
        graph_2.addEdgeDirected(2, 5);
        graph_2.addEdgeDirected(2, 4);
        System.out.println("Topological-Sort of the Graph is:");
        LinkedList<Integer> list_2 = graph_2.topologicalSort(1);
        System.out.println(list_2); // [1, 2, 4, 3, 5]
        System.out.println(graph_2.getDiscoveredTime().toString()); // [1, 6, 2, 7, 3]
        System.out.println(graph_2.getCompletionTime().toString()); // [10, 9, 5, 8, 4]
    }
}
