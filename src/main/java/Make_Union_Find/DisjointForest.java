package Make_Union_Find;

import java.util.Arrays;

/**
 * class DisjointForest
 */
public class DisjointForest {
    private int[] parent;       // parent[i] points to parent of element i or to self.
    private int[] rank;         // rank[i] holds the rank (cardinality) of root element i.
    private int numberElement;  // The number of disjoint sets

    public DisjointForest(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Expected n > 0");
        }
        parent = new int[n];
        rank = new int[n];
        numberElement = n;
    }

    public int getNumberElement() {
        return numberElement;
    }

    public int rank(int u) {
        u = root(u);
        return rank[u];
    }

    @Override
    public String toString() {
        return "DisjointSet {" + "parent=" + Arrays.toString(parent) + ", rank=" + Arrays.toString(rank) + ", " +
                "numberElement=" + numberElement + '}';
    }

    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
    }

    private int root(int u) {
        while (parent[u] != u) {
            u = parent[u];
        }

        return u;
    }

    public int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }

        return parent[x];
    }

    public void link(int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            if (rank[x] == rank[y]) {
                rank[y] = rank[y] + 1;
            }
        }
    }

    public void union(int a, int b) {
        link(findSet(a), findSet(b));
    }

    public static void main(String[] args) {
        DisjointForest set = new DisjointForest(10);
        for (int i = 0; i < set.numberElement; i++) {
            set.makeSet(i);
        }
        System.out.println(set); // DisjointSet {parent=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], rank=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0], numberElement=10}
        set.union(8, 9);
        System.out.println(set); // DisjointSet {parent=[0, 1, 2, 3, 4, 5, 6, 7, 9, 9], rank=[0, 0, 0, 0, 0, 0, 0, 0, 0, 1], numberElement=10}
        set.union(9, 7);
        System.out.println(set); // DisjointSet {parent=[0, 1, 2, 3, 4, 5, 6, 9, 9, 9], rank=[0, 0, 0, 0, 0, 0, 0, 0, 0, 1], numberElement=10}
        System.out.println(set.findSet(8));
        System.out.println(set.root(8));
        System.out.println(set.getNumberElement());

        DisjointForest set_2 = new DisjointForest(12);
        set_2.makeSet(2);
        set_2.makeSet(5);
        set_2.makeSet(1);
        set_2.makeSet(7);
        set_2.makeSet(9);
        set_2.makeSet(8);
        set_2.makeSet(4);
        System.out.println(set_2); // DisjointSet {parent=[0, 1, 2, 0, 4, 5, 0, 7, 8, 9, 0, 0], rank=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], numberElement=12}
    }
}
