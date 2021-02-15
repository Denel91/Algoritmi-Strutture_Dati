package Min_Heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class MinHeap
 */
public class MinHeap implements PriorityQueue {
    private ArrayList<Entry> heap; // internal representation

    //---------------- Nested Entry class ---------------- //
    static class Entry {
        private int k; // key
        private String v; // value

        public Entry(int key, String value) {
            this.k = key;
            this.v = value;
        }

        public Entry(int key) {
            this.k = key;
        }

        public int getK() {
            return k;
        }

        public String getV() {
            return v;
        }

        protected void setK(int key) {
            this.k = key;
        }

        protected void setV(String value) {
            this.v = value;
        }

        /*
        @Override
        public String toString() {
            return "(" + k + "," + v + ")";
        }*/

        @Override
        public String toString() {
            return "(" + k + ")";
        }

    } //----------- End of nested Entry class ----------- //

    // Default Constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Constructor
    public MinHeap(ArrayList<Entry> h) {
        heap = new ArrayList<>(h);
        builMinHeap(heap);
    }

    // Metodi per ottenere l'indice del nodo genitore oppure
    // il figlio sinistro/destro di un nodo di indice i.

    protected int parentId(int i) {
        return (i - 1) / 2;
    }

    protected int parent(ArrayList<Entry> heap, int i) {
        int index = (i - 1) / 2;
        Entry node = heap.get(index);
        return node.getK();
    }

    protected int leftId(int i) {
        return 2 * i + 1;
    }

    protected int left(ArrayList<Entry> heap, int i) {
        int index = 2 * i + 1;
        Entry node = heap.get(index);
        return node.getK();
    }

    protected int rightId(int i) {
        return 2 * i + 2;
    }

    protected int right(ArrayList<Entry> heap, int i) {
        int index = 2 * i + 2;
        Entry node = heap.get(index);
        return node.getK();
    }

    protected boolean hasLeft(int j) {
        return leftId(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return rightId(j) < heap.size();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Scambia l'elemento in posizione i con l'elemento in posizione j.
     *
     * @param h un ArrayList
     * @param i indice del primo elemento da scambiare
     * @param j indice del secondo elemento da scambiare
     */
    public static void swap(ArrayList<Entry> h, int i, int j) {
        Collections.swap(h, i, j);
    }

    /**
     * Ricostruisce un vettore in una MinHeap
     *
     * @param h        il vettore di nodi
     * @param i        indice iniziale del vettore
     * @param heapsize indice finale del vettore
     */
    public void heapify(ArrayList<Entry> h, int i, int heapsize) {
        int l = leftId(i);
        int r = rightId(i);
        int minimo;

        if (l <= heapsize && h.get(l).getK() < h.get(i).getK()) {
            minimo = l;

        } else {
            minimo = i;
        }

        if (r <= heapsize && h.get(r).getK() < h.get(minimo).getK()) {
            minimo = r;
        }

        if (minimo != i) {
            swap(h, i, minimo);
            heapify(h, minimo, heapsize);
        }
    }

    /**
     * Costruisce una MinHeap a partire da un vettore
     *
     * @param h il vettore di nodi
     */
    public void builMinHeap(ArrayList<Entry> h) {
        int heapsize = h.size() - 1;
        for (int i = heapsize / 2; i >= 0; i--) {
            heapify(h, i, heapsize);
        }
    }

    private void heapIncreaseKey(ArrayList<Entry> h, int i) {
        while (i > 0 && heap.get(i).getK() < heap.get(parentId(i)).getK()) {
            swap(heap, i, parentId(i));
            i = parentId(i);
        }
    }

    /**
     * Inserisce un Nodo in una MinHeap
     *
     * @param key   chiave da inserire
     * @param value valore da inserire
     * @return il Nodo inserito
     * @throws IllegalArgumentException se le chiavi non sono confrontabili tra loro
     */
    @Override
    public Entry insert(int key, String value) throws IllegalArgumentException {
        Entry newest = new Entry(key, value);
        heap.add(newest);
        int i = heap.size() - 1;
        heapIncreaseKey(heap, i);
        return newest;
    }

    /**
     * Inserisce un Nodo in una MinHeap
     *
     * @param entry Il Nodo da inserire
     * @return il Nodo inserito
     */
    public Entry insert(Entry entry) {
        heap.add(entry);
        int i = heap.size() - 1;
        heapIncreaseKey(heap, i);
        return entry;
    }

    /**
     * @return il Nodo con la chiave minima senza rimuoverlo
     */
    @Override
    public Entry min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * @return il Nodo con la chiave minima e la rimuove dalla MinHeap
     */
    @Override
    public Entry removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry answer = heap.get(0);
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(heap, 0, heap.size() - 1);
        return answer;
    }

    /**
     * @return una view della MinHeap
     */
    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(4, "c");
        heap.insert(5, "a");
        heap.insert(6, "z");
        heap.insert(15, "k");
        heap.insert(9, "f");
        heap.insert(7, "q");
        heap.insert(20, "b");
        heap.insert(16, "x");
        heap.insert(25, "j");
        heap.insert(14, "e");
        heap.insert(12, "h");
        heap.insert(11, "s");
        heap.insert(13, "w");
        System.out.println(heap.toString()); // [(4,c), (5,a), (6,z), (15,k), (9,f), (7,q), (20,b), (16,x), (25,j), (14,e), (12,h), (11,s), (13,w)]
        ArrayList<Entry> t = new ArrayList<>();
        t.add(new Entry(4));
        t.add(new Entry(5));
        t.add(new Entry(6));
        t.add(new Entry(15));
        t.add(new Entry(9));
        t.add(new Entry(7));
        t.add(new Entry(20));
        t.add(new Entry(16));
        t.add(new Entry(25));
        t.add(new Entry(14));
        t.add(new Entry(12));
        t.add(new Entry(11));
        t.add(new Entry(13));
        MinHeap minHeap = new MinHeap(t);
        System.out.println(minHeap.toString()); // [(4), (5), (6), (15), (9), (7), (20), (16), (25), (14), (12), (11), (13)]
        Entry min = minHeap.removeMin();
        System.out.println("Min: " + min.getK());
        System.out.println(minHeap.toString()); // [(5), (9), (6), (15), (12), (7), (20), (16), (25), (14), (13), (11)]

        Entry min2 = minHeap.removeMin();
        System.out.println("Min: " + min2.getK());
        System.out.println(minHeap.toString());

        Entry min3 = minHeap.removeMin();
        System.out.println("Min: " + min3.getK());
        System.out.println(minHeap.toString());
    }
}
