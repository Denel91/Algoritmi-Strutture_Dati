package Prim;

import java.util.Vector;
import java.util.Queue;
import java.util.PriorityQueue;

public class App {

    public Vector<Integer> mst_Prim(Graph G, int r) {
        Vector<Integer> key = new Vector<>();
        Vector<Integer> pi_greco = new Vector<>();
        key.setSize(G.getV());
        pi_greco.setSize(G.getV());

        for (int u = 0; u < G.getV(); u++){
            key.set(u, Integer.MAX_VALUE);
            pi_greco.set(u, null);
        }

        key.set(r, 0);
        Queue<Integer> Q = new PriorityQueue<>();
        for (int i = 0; i < G.getV(); i++) {
            Q.add(i);
        }

        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v : G.adj(u)){
                if ((Q.contains(v)) && (G.getWeight(u, v) < key.get(v))){
                    pi_greco.set(v, u);
                    key.set(v, G.getWeight(u, v));
                }
            }
        }
        return pi_greco;
    }

    public static void main(String[] args) {
        App app = new App();
        Graph G = new Graph(9);
        G.addEdge(0, 1, 4);
        G.addEdge(1, 2, 8);
        G.addEdge(2, 3, 7);
        G.addEdge(3, 4, 9);
        G.addEdge(4, 5, 10);
        G.addEdge(5, 6, 2);
        G.addEdge(6, 7, 1);
        G.addEdge(7, 0, 8);
        G.addEdge(8, 2, 2);
        G.addEdge(2, 5, 4);
        G.addEdge(8, 6, 6);
        G.addEdge(8, 7, 7);
        G.addEdge(1, 7, 11);
        G.addEdge(3, 5, 14);

        Graph g = new Graph(8);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 5, 7);
        g.addEdge(2, 1, 8);
        g.addEdge(2, 4, 6);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 5, 5);
        g.addEdge(4, 2, 6);
        g.addEdge(5, 1, 7);
        g.addEdge(5, 2, 4);
        g.addEdge(5, 3, 5);
        g.addEdge(5, 6, 5);
        g.addEdge(6,5, 5);
        g.addEdge(6,7,4);
        g.addEdge(7,6, 4);

        System.out.println(G);

        Vector<Integer> A = app.mst_Prim(G, 0);
        System.out.println(A); // [null, 0, 1, 2, 3, 2, 5, 6, 2]

        System.out.println(g);
        Vector<Integer> B = app.mst_Prim(g, 0);
        System.out.println(B); // [null, null, 0, null, 2, 2, 5, 6]
    }
}
