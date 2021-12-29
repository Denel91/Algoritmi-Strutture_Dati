package Kosaraju;
import java.util.*;

public class App {

    private Vector<Integer> parent;              // vettore dei predecessori
    private Vector<String> colour;               // vettore dei colori
    private Vector<Integer> discoveredTime;      // tempo di scoperta
    private Vector<Integer> completionTime;      // tempo di completamento
    private int time;                            // registra le informazioni temporali

    public void DFS(Graph G, int source) {
        colour = new Vector<>();
        parent = new Vector<>();
        colour.setSize(G.getVertexCount());
        parent.setSize(G.getVertexCount());
        for (int i = 0; i < G.getVertexCount(); i++) {
            colour.set(i, "white");
            parent.set(i, null);
        }
        time = 0;
        for (int i = source; i < G.getVertexCount(); i++) {
            if (colour.get(i).equals("white")) {
                DFS_Visit(G, i);
            }
        }
    }

    /**
     * Procedura di supporto
     *
     * @param u nodo del grafo visitato in quell'istante
     */
    private void DFS_Visit(Graph G, int u) {
        discoveredTime = new Vector<>();
        completionTime = new Vector<>();
        discoveredTime.setSize(G.getVertexCount());
        completionTime.setSize(G.getVertexCount());
        System.out.print(u + " ");
        time = time + 1;
        discoveredTime.set(u, time);
        colour.set(u, "gray");
        for (var v : G.adj(u)) {
            if (colour.get(v).equals("white")) {
                parent.set(v, u);
                DFS_Visit(G, v);
            }
        }

        colour.set(u, "black");
        time = time + 1;
        completionTime.set(u, time);
    }

    public static void main(String[] args) {
        App app = new App();
        Graph G = new Graph(8);

        G.addEdgeDirected(0, 1);
        G.addEdgeDirected(1, 2);
        G.addEdgeDirected(2, 3);
        G.addEdgeDirected(2, 4);
        G.addEdgeDirected(3, 0);
        G.addEdgeDirected(4, 5);
        G.addEdgeDirected(5, 6);
        G.addEdgeDirected(6, 4);
        G.addEdgeDirected(6, 7);
        System.out.println(G); // [[1], [2], [3, 4], [0], [5], [6], [4, 7], []]
        app.DFS(G, 0); // 0 1 2 3 4 5 6 7
        System.out.println();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
        System.out.println(depthFirstOrder);
        // DFS: pre=[0, 1, 2, 3, 4, 5, 6, 7], stack=[3, 7, 6, 5, 4, 2, 1, 0]
    }
}
