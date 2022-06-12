package Dijkstra;

import java.util.Vector;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

/**
 * class App
 */
public class App {
    Vector<Integer> distance = new Vector<>(); // stima del cammino minimo
    Vector<Integer> pi_greco = new Vector<>(); // vettore dei predecessori

    /**
     * Inizializza le stime dei cammini minimi e i predecessori
     *
     * @param G un Grafo orientato
     * @param s la sorgente del Grafo
     */
    public void initialize_Single_Source(Graph G, int s) {
        distance.setSize(G.getV());
        pi_greco.setSize(G.getV());

        for (int v = 0; v < G.getV(); v++) {
            distance.set(v, Integer.MAX_VALUE);
            pi_greco.set(v, null);
        }

        distance.set(s, 0);
    }

    /**
     * Rilassamento dell'arco (u, v) in tempo O(1)
     *
     * @param G un Grafo orientato
     * @param u un nodo del Grafo
     * @param v un nodo del Grafo
     */
    public void relax(Graph G, int u, int v) {
        if (distance.get(v) > (distance.get(u) + G.getWeight(u, v))) {
            distance.set(v, (distance.get(u) + G.getWeight(u, v)));
            pi_greco.set(v, u);
        }
    }

    /**
     * L'algoritmo di Dijkstra
     *
     * @param G un Grafo orientato
     * @param s la sorgente del Grafo
     * @return il vettore dei predecessori
     */
    public Vector<Integer> Dijkstra(Graph G, int s) {
        initialize_Single_Source(G, s);
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Set<Integer> S = new TreeSet<>();
        for (int i = 0; i < G.getV(); i++) {
            Q.add(i);
        }

        while (!Q.isEmpty()) {
            int u = Q.poll();
            S.add(u);
            for (int v : G.adj(u)) {
                relax(G, u, v);
            }
        }

        System.out.println(S);

        return pi_greco;
    }

    /**
     * Shortest paths from all vertices to a destination
     *
     * @param G
     * @param s
     * @return
     */
    public int[] minimumPaths_SingleDestination(Graph G, int s) {
        int[] distance = new int[G.getV()];
        int[] pi_greco = new int[G.getV()];

        for (int i = 0; i < G.getV(); i++)  {
            distance[i] = Integer.MAX_VALUE;
            pi_greco[i] = -1;
        }

        distance[s] = 0;

        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v : G.adj(u)) {
                if (distance[v] > (distance[u] + G.getWeight(u, v))) {
                    distance[v] = distance[u] + G.getWeight(u, v);
                    pi_greco[v] = u;
                    Q.add(v);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        App app = new App();

        Graph G = new Graph(5);
        G.addEdge(0, 1, 3);
        G.addEdge(0, 4, 5);
        G.addEdge(1, 2, 6);
        G.addEdge(1, 4, 2);
        G.addEdge(2, 3, 2);
        G.addEdge(3, 0, 3);
        G.addEdge(3, 2, 7);
        G.addEdge(4, 1, 1);
        G.addEdge(4, 2, 4);
        G.addEdge(4, 3, 6);
        System.out.println(G);
        System.out.println(G.getV()); // 5
        System.out.println(G.getE()); // 10
        Vector<Integer> A = app.Dijkstra(G, 0);
        System.out.println(A); // [null, 0, 1, 2, 0]

        Graph G_1 = new Graph(5);
        G_1.addEdge(0, 1, 10);
        G_1.addEdge(0, 4, 5);
        G_1.addEdge(1, 2, 1);
        G_1.addEdge(1, 4, 2);
        G_1.addEdge(2, 3, 4);
        G_1.addEdge(3, 0, 7);
        G_1.addEdge(3, 2, 6);
        G_1.addEdge(4, 1, 3);
        G_1.addEdge(4, 2, 9);
        G_1.addEdge(4, 3, 2);
        System.out.println(G_1);
        Vector<Integer> B = app.Dijkstra(G_1, 0);
        System.out.println(B); // [null, 4, 1, 4, 0]

        Graph G_2 = new Graph(5);
        G_2.addEdgeReverse(0, 1, 10);
        G_2.addEdgeReverse(0, 4, 5);
        G_2.addEdgeReverse(1, 2, 1);
        G_2.addEdgeReverse(1, 4, 2);
        G_2.addEdgeReverse(2, 3, 4);
        G_2.addEdgeReverse(3, 0, 7);
        G_2.addEdgeReverse(3, 2, 6);
        G_2.addEdgeReverse(4, 1, 3);
        G_2.addEdgeReverse(4, 2, 9);
        G_2.addEdgeReverse(4, 3, 2);
        System.out.println(G_2);

        int[] C = app.minimumPaths_SingleDestination(G_2, 0);
        System.out.println(Arrays.toString(C));
    }
}
