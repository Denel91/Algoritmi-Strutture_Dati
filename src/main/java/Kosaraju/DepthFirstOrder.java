package Kosaraju;

import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Stack<Integer> stack;

    public DepthFirstOrder() {}

    public DepthFirstOrder(Graph G) {
        this.marked = new boolean[G.getVertexCount()];
        this.pre = new PriorityQueue<>(G.getVertexCount());
        this.stack = new Stack<>();

        for (int v = 0; v < G.getVertexCount(); v++) {
            if (!marked[v]) {
                dfs_Visit(G, v);
            }
        }
    }

    private void dfs_Visit(Graph G, int v) {
        pre.add(v);
        marked[v] = true;
        for (var w : G.adj(v)) {
            if (!marked[w]) {
                dfs_Visit(G, w);
            }
        }

        stack.push(v);
    }

    @Override
    public String toString() {
        return "DFS: " + "pre=" + pre + ", stack=" + stack + "";
    }
}
