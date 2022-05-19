package B_Tree;

/**
 * class BTree
 */
public class BTree {
    private final int t;  // grado di un B-Tree
    private Node root;    // nodo radice di un B-Tree

    // Default Constructor
    public BTree(int t) {
        this.root = new Node(t, true);
        this.root.leaf = true;
        this.root.n = 0;
        this.t = t;
    }

    public Node getRoot() {
        return root;
    }

    public int getT() {
        return t;
    }

    public void B_Tree_Create(BTree T) {
        Node x = new Node(T.getT(), true);
        x.leaf = true;
        x.n = 0;
        T.root = x;
    }

    private void split_Child(Node x, int i) {
        Node z = new Node(t, true);
        Node y = x.getChild(i);
        z.leaf = y.leaf;
        z.n = t - 1;
        for (int j = 0; j < t - 1; j++) {
            z.key[j] = y.key[j + t];
        }

        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.child[j] = y.child[j + t];
            }
        }

        y.n = t - 1; // new size of y

        for (int j = x.n; j >= i + 1; j--) {
            x.child[j + 1] = x.child[j];
        }

        x.child[i + 1] = z;

        for (int j = x.n; j >= i; j--) {
            x.key[j + 1] = x.key[j];
        }

        x.key[i] = y.key[t];
        x.n++;
    }

    public void insert_NonFull(Node x, int k) {
        int i = x.n - 1;
        if (x.isLeaf()) { // Se il nodo x è una foglia
            while (i >= 0 && k < x.key[i]) {
                x.key[i + 1] = x.key[i];
                i--;
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            while (i >= 0 && k < x.key[i]) {
                i--;
            }
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * t - 1) {
                split_Child(tmp, i);
                if (k > x.key[i]) {
                    i++;
                }
            }

            insert_NonFull(x.child[i], k);
        }
    }

    public void tree_Insert(BTree T,int k) {
        Node r = T.root;
        if (r.n == 2 * t - 1) {
            Node s = new Node(t, true);
            T.root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split_Child(s, 0);
            insert_NonFull(s, k);
        } else {
            insert_NonFull(r, k);
        }
    }

    @Override
    public String toString() {
        return "{" + root + "}";
    }

    public void display() {
        display(root);
    }

    // Display the tree
    private void display(Node x) {
        for (int i = 0; i < x.getN(); i++) {
            System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
            for (int i = 0; i < x.getN() + 1; i++) {
                display(x.child[i]);
            }
        }
    }

    public static void main(String[] args) {
        /*
        BTree tree = new BTree(3);
        tree.tree_Insert(8);
        tree.tree_Insert(9);
        tree.tree_Insert(10);
        tree.tree_Insert(11);
        tree.tree_Insert(15);
        tree.tree_Insert(20);
        tree.tree_Insert(17);
        tree.display();
        */

        BTree tree1 = new BTree(2); // Massimo 3 elementi
        tree1.B_Tree_Create(tree1);
        tree1.tree_Insert(tree1, 5);
        tree1.tree_Insert(tree1, 3);
        tree1.tree_Insert(tree1, 2);
        tree1.tree_Insert(tree1, 6);
    }
}
