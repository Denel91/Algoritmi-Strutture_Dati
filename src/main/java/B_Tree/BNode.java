package B_Tree;

/**
 * Questa è una implementazione della classe Nodo per i Balanced-Tree.
 *
 * @version 12/04/2021
 */
public class BNode {
    int t;          // variabile per determinare il grado di un B-Tree
    int count;      // numero di chiavi in un nodo
    int key[];      // array con i valori delle chiavi
    BNode child[];  // array per i figli di un nodo
    boolean leaf;   // variabile per identificare se un nodo è una foglia o no
    BNode parent;   // genitore del nodo corrente

    // Default Constructor
    public BNode() {}

    // Valore iniziale del costruttore per un nuovo nodo
    public BNode(int t, BNode parent) {
        this.t = t;
        this.parent = parent;
        this.count = 0; // fino a quando non aggiungeremo le chiavi in seguito
        this.leaf = true; // ogni nodo all' inizio è una foglia
        this.key = new int[2 * t - 1]; // array delle chiavi con dimensione massima
        this.child = new BNode[2 * t]; // array dei figli con dimensione massima
    }

    /**
     * @param index indice di un nodo
     * @return il valore della chiave ad un determinato indice
     */
    public int getKey(int index) {
        return key[index];
    }

    /**
     * @param index indice di un nodo
     * @return l'i-esimo nodo figlio ad un determinato indice
     */
    public BNode getChild(int index) {
        return child[index];
    }

    public boolean isLeaf() {
        return leaf;
    }

    public int getCount() {
        return count;
    }

    public int getT() {
        return t;
    }

    public BNode getParent() {
        return parent;
    }
}
