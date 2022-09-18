package Grafi;

import java.util.LinkedList;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

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
    private int[] in_Degree;
    private int[] out_Degree;

    /**
     * Default Constructor
     *
     * @param vertexCount numero di vertici del grafo
     */
    public TopologicalSort(int vertexCount) {
        this.vertexCount = vertexCount;
        this.parent = new Vector<>();
        this.colour = new Vector<>();
        this.completionTime = new Vector<>();
        this.discoveredTime = new Vector<>();
        this.in_Degree = new int[vertexCount];
        this.out_Degree = new int[vertexCount];
        parent.setSize(vertexCount);
        colour.setSize(vertexCount);
        completionTime.setSize(vertexCount);
        discoveredTime.setSize(vertexCount);
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
            in_Degree[w]++;
            out_Degree[v]++;
        }
    }

    public int outDegree(int v) {
        return adj[v].size();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     *
     * @param G
     * @return
     */
    public ArrayList<Integer> topologicalSortByInDegree(TopologicalSort G) {
        ArrayList<Integer> sorted = new ArrayList<>();
        Queue<Integer> Q = new PriorityQueue<>();

        for (int v = 0; v < G.getVertexCount(); v++) {
            if (in_Degree[v] == 0) {
                Q.add(v);
            }
        }

        while (!Q.isEmpty()) {
            int v = Q.poll();
            sorted.add(v);

            for (int w : G.adj(v)) {
                in_Degree[w]--;

                if (in_Degree[w] == 0) {
                    Q.add(w);
                }
            }
        }

        return sorted;
    }

    /**
     * Ordinamento Topologico:
     * Ordinamento lineare di tutti i vertici di un grafo aciclico diretto
     *
     * Complessità: Θ(V + E)
     *
     * @param source source nodo di partenza
     * @return una lista ordinata dei nodi del grafo
     */
    public LinkedList<Integer> topologicalSort(int source) {
        for (int i = 0; i < vertexCount; i++) {
            colour.set(i, "white");
            parent.set(i, null);
        }
        time = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
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

    public int[] getIn_Degree() {
        return in_Degree;
    }

    public int[] getOut_Degree() {
        return out_Degree;
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdgeDirected(1, 2);
        graph.addEdgeDirected(1, 3);
        graph.addEdgeDirected(2, 4);
        graph.addEdgeDirected(2, 5);
        System.out.println("In-Degree: " + Arrays.toString(graph.getIn_Degree()));
        System.out.println("Out_Degree: " + Arrays.toString(graph.getOut_Degree()));
        System.out.println("Topological-Sort of the Graph is:");
        LinkedList<Integer> list = graph.topologicalSort(1);
        ArrayList<Integer> list2 = graph.topologicalSortByInDegree(graph); // [0, 1, 2, 3, 4, 5]
        System.out.println("Topological-Sort with In-Degree: " + list2.toString());
        System.out.println(list); // [1, 3, 2, 5, 4]
        System.out.println("outDegree: " + graph.outDegree(2));

        TopologicalSort graph_2 = new TopologicalSort(6);
        graph_2.addEdgeDirected(1, 3);
        graph_2.addEdgeDirected(1, 2);
        graph_2.addEdgeDirected(2, 5);
        graph_2.addEdgeDirected(2, 4);
        graph_2.addEdgeDirected(3, 5);
        System.out.println("Topological-Sort of the Graph is:");
        LinkedList<Integer> list_2 = graph_2.topologicalSort(1);
        System.out.println(list_2); // [1, 2, 4, 3, 5]

        TopologicalSort graph_3 = new TopologicalSort(8);
        graph_3.addEdgeDirected(7,6);
        graph_3.addEdgeDirected(7,5);
        graph_3.addEdgeDirected(6,4);
        graph_3.addEdgeDirected(6,3);
        graph_3.addEdgeDirected(5,4);
        graph_3.addEdgeDirected(5,2);
        graph_3.addEdgeDirected(3,1);
        graph_3.addEdgeDirected(2,1);
        graph_3.addEdgeDirected(1,0);
        LinkedList<Integer> list_3 = graph_3.topologicalSort(7);
        System.out.println("Topological-Sort of the Graph is: ");
        System.out.println(list_3); // [7, 6, 5, 4, 3, 2, 1, 0]

        System.out.println();
        TopologicalSort graph_4 = new TopologicalSort(7);
        graph_4.addEdgeDirected(0, 1);
        graph_4.addEdgeDirected(0, 2);
        graph_4.addEdgeDirected(0, 3);
        graph_4.addEdgeDirected(1, 4);
        graph_4.addEdgeDirected(2, 1);
        graph_4.addEdgeDirected(2, 4);
        graph_4.addEdgeDirected(3, 5);
        graph_4.addEdgeDirected(3, 6);
        graph_4.addEdgeDirected(5, 6);
        LinkedList<Integer> list_4 = graph_4.topologicalSort(0);
        System.out.println(list_4);
    }
}
