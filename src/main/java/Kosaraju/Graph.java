package Kosaraju;

import java.util.*;

public class Graph {
    private int vertexCount;                       // numero di vertici nel Grafo
    private LinkedList<Integer> adj[];             // lista di adiacenza
    private Stack<Integer> stack = new Stack<>();

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++)
             adj[i] = new LinkedList<>();
    }

    // Transpose the graph
    public Graph transpose() {
        Graph g = new Graph(vertexCount);
        for (int s = 0; s < vertexCount; s++) {
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(s);
            }
        }
        return g;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
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

    public int getVertexCount() {
        return vertexCount;
    }

    public void dfs(Graph G, int v, boolean[] marked) {
        marked[v] = true;
        for (var w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, marked);
            }
        }

        stack.push(v);
    }

    public void dfs_2(Graph G, int v, boolean[] marked) {
        System.out.print(v + " ");
        marked[v] = true;
        for (var w : G.adj(v)) {
            if (!marked[w]) {
                dfs_2(G, w, marked);
            }
        }

        stack.push(v);
    }

    public void printSCC(Graph G) {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                dfs(G, i, visited);
            }
        }

        Graph G_reverse = G.transpose();

        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }

        while (!stack.isEmpty()) {
            int s = stack.pop();
            if (!visited[s]) {
                dfs_2(G_reverse, s, visited);
                System.out.println();
            }
        }
    }

    /**
     * DFS Iterativo
     *
     * @param G un Grafo
     * @param r in nodo di partenza della visita
     */
    public void iterativeDFS(Graph G, int r) {
        Stack<Integer> S = new Stack<>();
        S.push(r);
        boolean[] visited = new boolean[G.getVertexCount()];

        while (!S.isEmpty()) {
            int u = S.pop();
            if (visited[u]){
                continue;
            }

            visited[u] = true;
            System.out.print(u + " ");

            for (var v : G.adj(u)){
                if (!visited[v]) {
                    S.push(v);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "" + Arrays.toString(adj) + "";
    }

    public static void main(String[] args) {
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
        G.printSCC(G);
        // 0 3 2 1 --> Strongly Connected Components
        // 4 6 5 --> Strongly Connected Components
        // 7 --> Strongly Connected Components

        G.iterativeDFS(G, 0); // 0 1 2 4 5 6 7 3
    }
}
