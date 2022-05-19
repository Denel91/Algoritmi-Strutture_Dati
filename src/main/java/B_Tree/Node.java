package B_Tree;

import java.util.Arrays;

/**
 * Questa è una implementazione della classe Nodo per i Balanced-Tree.
 *
 * @version 12/04/2021
 */
public class Node {
    int t;          // variabile per determinare il grado minimo di un B-Tree
    int n;          // numero di chiavi in un nodo
    int key[];      // array con i valori delle chiavi
    Node child[];   // array per i figli di un nodo
    boolean leaf;   // variabile per identificare se un nodo è una foglia o no

    /**
     * Valore iniziale del costruttore per un nuovo nodo
     *
     * @param t
     * @param leaf
     */
    public Node(int t, boolean leaf) {
        this.t = t;
        this.n = 0;                     // fino a quando non aggiungeremo le chiavi in seguito
        this.leaf = true;               // ogni nodo all' inizio è una foglia
        this.key = new int[2 * t - 1];  // array delle chiavi con dimensione massima
        this.child = new Node[2 * t];   // array dei figli con dimensione massima
    }

    public int getN() {
        return n;
    }

    public int getT() {
        return t;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public int getKey(int i) {
        return key[i];
    }

    public Node getChild(int j) {
        return child[j];
    }

    @Override
    public String toString() {
        return "key=" + Arrays.toString(key) + ", child=" + Arrays.toString(child);
    }
}
