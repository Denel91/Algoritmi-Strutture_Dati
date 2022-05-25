package Grafi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.Arrays;

/**
 * Breadth-First Search
 *
 * @version 12/10/2021
 */
public class BreadthFirstSearch {
    private int vertexCount;              // numero di vertici nel Grafo
    private LinkedList<Integer> adj[];    // lista di adiacenza
    private Vector<Integer> distance;     // vettore delle distanze
    private Vector<Integer> parent;       // vettore dei predecessori
    private Vector<String> colour;        // vettore dei colori

    /**
     * Default Constructor
     *
     * @param vertexCount numero di vertici del grafo
     */
    public BreadthFirstSearch(int vertexCount) {
        this.vertexCount = vertexCount;
        this.distance = new Vector<>();
        this.parent = new Vector<>();
        this.colour = new Vector<>();
        distance.setSize(vertexCount);
        parent.setSize(vertexCount);
        colour.setSize(vertexCount);
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public Vector<Integer> getDistance() {
        return distance;
    }

    public Vector<Integer> getParent() {
        return parent;
    }

    public Vector<String> getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "GRAPH \n" + "vertexCount: " + vertexCount + "\n" + "adj: " + Arrays.toString(adj) + "\n" + "distance:" +
                " " + distance + "\n" + "parent: " + parent + "\n" + "colour: " + colour;
    }

    /**
     * Unisce rispettivamente tra loro due vertici del grafo
     *
     * @param v indice di un vertice
     * @param w indice di un vertice
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
     * Stampa i vertici di un cammino minimo da s a v.
     *
     * @param G un Grafo
     * @param s vertice sorgente
     * @param v vertici destinazione
     */
    public void print_Path(BreadthFirstSearch G, int s, int v) {
        if (v == s) {
            System.out.print(s);
        } else if (parent.get(v) == null){
            System.out.print("Non ci sono cammini da " + s + " a " + v);
        } else {
            print_Path(G, s, parent.get(v));
            System.out.print("--" + v + "");
        }
    }

    /**
     * Diametro di un Grafo
     *
     * @param G un grafo non orientato
     * @return
     */
    public int diameter(BreadthFirstSearch G) {
        int max = 0;
        for (int r = 0; r < G.getVertexCount(); r++) {
            Queue<Integer> Q = new LinkedList<>();
            Q.add(r);
            distance.setSize(G.getVertexCount());
            for (int u = 0;  u < G.getVertexCount(); u++) {
                distance.set(u, -1);
            }

            distance.set(r, 0);

            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v : G.adj[u]) {
                    if (distance.get(v) < 0){
                        distance.set(v, distance.get(u) + 1);
                        if (distance.get(v) > max){
                            max = distance.get(v);
                        }

                        Q.add(v);
                    }
                }
            }
        }

        return max;
    }

    /**
     * Breadth-First Search
     *
     * @param source vertice di partenza
     */
    public void BFS(int source) {
        for (int i = 0; i < vertexCount; i++) {
            colour.set(i, "white");
            distance.set(i, Integer.MAX_VALUE);
            parent.set(i, null);
        }
        colour.set(source, "gray");
        distance.set(source, 0);
        parent.set(source, null);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            var u = queue.poll();
            System.out.print(u + " ");
            for (var j : adj[u]) {
                if (colour.get(j).equals("white")) {
                    colour.set(j, "grey");
                    distance.set(j, distance.get(u) + 1);
                    parent.set(j, u);
                    queue.add(j);
                }
            }

            colour.set(u, "black");
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        BreadthFirstSearch graph = new BreadthFirstSearch(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 6);
        graph.addEdge(3, 5);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);

        //System.out.println(graph);
        System.out.println("The Breadth-First Search of the Graph is:");
        graph.BFS(0);
        System.out.println();
        System.out.println(graph.getVertexCount());
        System.out.println(graph.getColour().toString());
        System.out.println(graph.getParent().toString());
        System.out.println(graph.getDistance().toString());
        graph.print_Path(graph, 0, 5);
        System.out.println();
        System.out.println(graph.diameter(graph));
    }
}


