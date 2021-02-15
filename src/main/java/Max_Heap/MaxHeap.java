package Max_Heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class MaxHeap
 */
public class MaxHeap implements PriorityQueue {
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

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(ArrayList<Entry> h) {
        heap = new ArrayList<>(h);
        builMaxHeap(heap);
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

    public ArrayList<Entry> getHeap() {
        return heap;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void builMaxHeap(ArrayList<Entry> h) {
        int heapsize = h.size() - 1;
        for (int i = heapsize / 2; i >= 0; i--) {
            maxHeapify(h, i, heapsize);
        }
    }

    public void maxHeapify(ArrayList<Entry> h, int i, int heapsize) {
        int l = leftId(i);
        int r = rightId(i);
        int massimo;

        if (l <= heapsize && h.get(l).getK() > h.get(i).getK()) {
            massimo = l;

        } else {
            massimo = i;
        }

        if (r <= heapsize && h.get(r).getK() > h.get(massimo).getK()) {
            massimo = r;
        }

        if (massimo != i) {
            swap(h, i, massimo);
            maxHeapify(h, massimo, heapsize);
        }
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

    private void heapIncreaseKey(ArrayList<Entry> h, int i) {
        while (i > 0 && h.get(i).getK() > h.get(parentId(i)).getK()) {
            swap(h, i, parentId(i));
            i = parentId(i);
        }
    }

    @Override
    public Entry insert(int key, String value) throws IllegalArgumentException {
        Entry newest = new Entry(key, value);
        heap.add(newest);
        int i = heap.size() - 1;
        heapIncreaseKey(heap, i);
        return newest;
    }

    /**
     * Inserisce un Nodo in una MaxHeap
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

    @Override
    public Entry max() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry removeMax() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry answer = heap.get(0);
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        maxHeapify(heap, 0, size());
        return answer;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
        ArrayList<Entry> t = new ArrayList<>();
        t.add(new Entry(16));
        t.add(new Entry(14));
        t.add(new Entry(10));
        t.add(new Entry(8));
        t.add(new Entry(7));
        t.add(new Entry(9));
        t.add(new Entry(3));
        t.add(new Entry(2));
        t.add(new Entry(4));
        t.add(new Entry(1));
        MaxHeap maxHeap = new MaxHeap(t);
        System.out.println(maxHeap.toString());
        System.out.println(maxHeap.removeMax().toString()); // (16)
        System.out.println(maxHeap.max().toString()); // (14) --> Dopo la rimozione del 16
        maxHeap.insert(5, "");
        System.out.println(maxHeap.toString()); // [(16), (14), (10), (8), (7), (9), (3), (2), (4), (1), (5)]
        int left = maxHeap.leftId(4);
        int right = maxHeap.rightId(4);
        System.out.println(left); // 9
        System.out.println(right); // 10
        int l = maxHeap.left(maxHeap.getHeap(), 4);
        int r = maxHeap.right(maxHeap.getHeap(), 4);
        System.out.println(l); // 1
        System.out.println(r); // 5
    }
}
