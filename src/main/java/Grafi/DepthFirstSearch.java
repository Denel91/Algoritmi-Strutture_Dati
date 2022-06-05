package Grafi;

import java.util.LinkedList;
import java.util.Vector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Depth-First Search implementation class
 *
 * @version 27/05/2022
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

    /**
     * Depth-First Search iterativa
     *
     * @param G un Grafo orientato
     * @param r sorgente del grafo
     */
    public void DFS_Iterative(DepthFirstSearch G, int r) {
        Stack<Integer> S = new Stack<>();
        S.push(r);
        boolean[] visitato = new boolean[G.getVertexCount()];
        for (int u = 0; u < G.getVertexCount(); u++) {
            visitato[u] = false;
            parent.set(u, null);
        }

        visitato[r] = true;

        while (!S.isEmpty()) {
            int u = S.pop();
            System.out.print(u + " ");
            for (int v : G.adj[u]) {
                if (!visitato[v]){
                    visitato[v] = true;
                    parent.set(v, u);
                    S.push(v);
                }
            }
        }
    }

    /**
     * Verifica la presenza di cicli in grafi orientati
     *
     * @param G un grafo orientato
     * @return
     */
    public boolean hasCycles(DepthFirstSearch G) {
        colour.setSize(G.getVertexCount());
        for (int i = 0; i < G.getVertexCount(); i++) {
            colour.set(i, "white");
        }

        for (int i = 0; i < G.getVertexCount(); i++) {
            if (colour.get(i).equals("white")) {
                if (hasCyclesRec(G, i, colour))
                    return true;
            }
        }

        return false;
    }

    /**
     * Procedura di supporto per i grafi orientati
     *
     * @param G
     * @param u
     * @param colour
     * @return
     */
    private boolean hasCyclesRec(DepthFirstSearch G, int u, Vector<String> colour) {
        colour.set(u, "gray");
        for (Integer v : G.adj[u]) {
            if (colour.get(v).equals("gray")) {
                return true;
            }

            if (colour.get(v).equals("white") && hasCyclesRec(G, v, colour)) {
                return true;
            }
        }

        colour.set(u, "black");
        return false;
    }

    /**
     * Verifica di cicli nei grafi non orientati.
     *
     * During DFS, for any current vertex ‘x’ (currently visiting vertex) if there is an adjacent vertex ‘y’ is present
     * which is already visited and ‘y’ is not a direct parent of ‘x’ then there is a cycle in graph.
     * * Why not parent:
     * Let’s assume, vertex ‘x’ and ‘y’ and we have edge between them: x--y.
     * Now do DFS from ‘x’, once you reach to ‘y’, will do the DFS from ‘y’ and adjacent vertex is ‘x’ and since
     * its already visited so there should be cycle but actually there is no cycle since ‘x’ is a parent of ‘y’.
     * That is why we will ignore visited vertex if it is parent of current vertex.
     *
     * @param G
     * @return
     */
    public boolean isCyclic(DepthFirstSearch G) {
        boolean[] visited = new boolean[G.getVertexCount()];
        for (int i = 0; i < G.getVertexCount(); i++) {
            visited[i] = false;
        }

        for (int u = 0; u < G.getVertexCount(); u++) {
            if (!visited[u]) {
                if (isCyclicRec(G, u, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Procedura di supporto per i grafi non orientati
     *
     * @param G
     * @param u
     * @param visited
     * @param parent
     * @return
     */
    private boolean isCyclicRec(DepthFirstSearch G, int u, boolean[] visited, int parent) {
        visited[u] = true;
        for (Integer v : G.adj[u]) {
            if (!visited[v]) {
                if (isCyclicRec(G, v, visited, u))
                    return true;
            } else if (v != parent) {
                return true;
            }
        }

        return false;
    }

    /**
     * Conta il numero di percorsi semplici che ci sono da u a v
     *
     * @param G
     * @param u
     * @param v
     * @return
     */
    public int simplePaths(DepthFirstSearch G, int u, int v) {
        int paths = 0;
        if (u == v) {
            return 1;
        } else if (parent.get(u) != null) {
            return paths;
        } else {
            for (var w : G.adj[u]) {
                paths = paths + simplePaths(G, w, v);
            }
        }

        return paths;
    }

    /**
     * Transpose the graph
     *
     * @return il grafo trasposto
     */
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

    /**
     *
     * @param G
     * @param s
     * @param d
     * @return
     */
    public boolean isReachable(DepthFirstSearch G, int s, int d) {
        if (s == d) {
            return true;
        }
        Stack<Integer> S = new Stack<>();
        boolean[] visitato = new boolean[G.getVertexCount()];
        for (int u = 0; u < G.getVertexCount(); u++) {
            visitato[u] = false;
            parent.set(u, null);
        }
        S.push(s);
        visitato[s] = true;
        while (!S.isEmpty()) {
            int u = S.pop();
            for (int v : G.adj[u]) {
                if (v == d)
                    return true;
                if (!visitato[v]){
                    visitato[v] = true;
                    parent.set(v, u);
                    S.push(v);
                }
            }
        }

        return false;
    }

    /**
     * Find All Simple Paths Between Two Vertices in a Graph
     *
     * @param G
     * @param source
     * @param destination
     */
    public void printAllPaths(DepthFirstSearch G, int source, int destination) {
        boolean[] visited = new boolean[G.getVertexCount()];
        ArrayList<Integer> paths = new ArrayList<>();
        paths.add(source);
        DFS_All_Simple_Paths(G, source, destination, visited, paths);
    }

    /**
     * Procedura di supporto
     *
     * @param G
     * @param u
     * @param v
     * @param visited
     * @param localPaths
     */
    private void DFS_All_Simple_Paths(DepthFirstSearch G, int u, int v, boolean[] visited, List<Integer> localPaths) {
        if (u == v) {
            System.out.println(localPaths);
            return;
        }

        visited[u] = true;
        for (var i : G.adj[u]) {
            if (!visited[i]) {
                localPaths.add(i);
                DFS_All_Simple_Paths(G, i, v, visited, localPaths);
                localPaths.remove(i);
            }
        }

        visited[u] = false;
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
        graph.addEdge(4, 5);
        System.out.println("The Depth-First Search of the Graph is:");
        graph.DFS(1); // 1 2 4 5 3
        System.out.println();
        System.out.println(graph.isCyclic(graph));
        System.out.println("The Depth-First Search of the Graph is:");
        graph.DFS_Iterative(graph, 1);
        System.out.println();
        System.out.println(graph.getParent());
        System.out.println(graph.getVertexCount());

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

        // Strongly Connected Components example
        DepthFirstSearch G = new DepthFirstSearch(6);
        G.addEdgeDirected(0,1);
        G.addEdgeDirected(1, 2);
        G.addEdgeDirected(1, 3);
        G.addEdgeDirected(2, 0);
        G.addEdgeDirected(3, 4);
        G.addEdgeDirected(4, 3);
        G.addEdgeDirected(4, 5);
        System.out.println("Graph:");
        System.out.println(G);
        System.out.println("The Depth-First Search of the Graph is:");
        G.DFS(0); // 0 1 2 3 4 5
        System.out.println();
        System.out.println(G.getDiscoveredTime());
        System.out.println();
        System.out.println(G.getCompletionTime());
        System.out.println();
        System.out.println(G.getParent());
        System.out.println("Transpose Graph:");
        DepthFirstSearch graph_5 = G.transpose();
        System.out.println(graph_5);
        graph_5.DFS(0); // 0 2 1 3 4 5
        System.out.println();
        System.out.println(graph_5.getDiscoveredTime());
        System.out.println();
        System.out.println(graph_5.getCompletionTime());

        System.out.println();

        DepthFirstSearch graph_6 = new DepthFirstSearch(3);
        graph_6.addEdgeDirected(0, 1);
        graph_6.addEdgeDirected(1, 2);
        graph_6.addEdgeDirected(2, 0);
        System.out.println(graph_6);
        System.out.println(graph_6.isCyclic(graph_6));
        System.out.println(graph_6.hasCycles(graph_6));

        System.out.println();

        DepthFirstSearch graph_7 = new DepthFirstSearch(6);
        graph_7.addEdgeDirected(0,1);
        graph_7.addEdgeDirected(0,5);
        graph_7.addEdgeDirected(1,2);
        graph_7.addEdgeDirected(5,2);
        graph_7.addEdgeDirected(2,3);
        graph_7.addEdgeDirected(3,4);
        System.out.println(graph_7.simplePaths(graph_7, 0, 4));
        System.out.println(graph_7.isReachable(graph_7, 0, 4)); // true

        DepthFirstSearch graph_8 = new DepthFirstSearch(4);
        graph_8.addEdgeDirected(0,1);
        graph_8.addEdgeDirected(0,2);
        graph_8.addEdgeDirected(0,3);
        graph_8.addEdgeDirected(2,0);
        graph_8.addEdgeDirected(2,1);
        graph_8.addEdgeDirected(1,3);
        graph_8.printAllPaths(graph_8, 2, 3); // [2, 0, 1, 3] [2, 0, 3] [2, 1, 3]
    }
}
