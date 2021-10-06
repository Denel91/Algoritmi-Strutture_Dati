package Grafi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.Arrays;

/**
 * Breadth-First Search
 *
 * @version 06/10/2021
 */
public class Graph {
    private int vertexCount;              // numero di vertici nel Grafo
    private LinkedList<Integer> adj[];    // lista di adiacenza
    private Vector<Integer> distance;     // vettore delle distanze
    private Vector<Integer> parent;       // vettore dei predecessori
    private Vector<String> colour;        // vettore dei colori

    public Graph(int vertexCount) {
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

    @Override
    public String toString() {
        return "GRAPH \n" + "vertexCount: " + vertexCount + "\n" + "adj: " + Arrays.toString(adj) + "\n" + "distance:" +
                " " + distance + "\n" + "parent: " + parent + "\n" + "colour: " + colour;
    }

    public void addEdge(int v, int w) {
        if (!adj[v].contains(w)) {
            adj[v].add(w);
        }

        if (!adj[w].contains(v)) {
            adj[w].add(v);
        }
    }

    public void BFS(int source) {
        for (int i = 0; i < vertexCount; i++) {
            distance.set(i, Integer.MAX_VALUE);
            parent.set(i, null);
            colour.set(i, "white");
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
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        //System.out.println(graph);
        System.out.println("The Breadth-First Search of the Graph is:");
        graph.BFS(0);
    }
}


