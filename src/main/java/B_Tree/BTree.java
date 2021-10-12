package B_Tree;

public class BTree {
    int order; // grado di un B-Tree
    BNode root; // nodo radice di un B-Tree

    // Default Constructor
    public BTree(int order) {
        this.order = order;
        this.root  = new BNode(order, null);
    }

    private void split(BNode x, BNode y, int i) {
        BNode z = new BNode(order, null);
        z.leaf = y.leaf;
        z.count = order - 1;

        for (int j = 0; j < order - 1; j++) {
            z.key[j] = y.key[j + order];
        }

        if (!y.leaf) {
            for (int j = 0; j < order; j++) {
                z.child[j] = y.child[j + order];
            }
        }

        y.count = order - 1; // new size of y

        for (int j = x.count; j >= i + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[i + 1] = z;

        for (int j = x.count - 1; j >= i; j--) {
            x.key[j + 1] = x.key[j];
        }

        x.key[i] = y.key[order - 1];
        y.key[order - 1] = 0;

        for (int j = 0; j < order - 1; j++) {
            y.key[j + order] = 0; //'delete' old values
        }

        x.count++;
    }

    /**
     * @param n
     */
    public void print(BNode n) {
        for (int i = 0; i < n.getCount(); i++) {
            System.out.print(n.getKey(i) + " ");//this part prints root node
        }

        if (!n.isLeaf()) {//this is called when root is not leaf;
            for (int j = 0; j <= n.getCount(); j++) {
                if (n.getChild(j) != null) {
                    System.out.println();
                    print(n.getChild(j));
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
