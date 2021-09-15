package Min_Heap_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class MinHeap {
    private ArrayList<Integer> heap; // rappresentazione interna tramite un Vettore

    /**
     *
     */
    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * @param items
     */
    public MinHeap(ArrayList<Integer> items) {
        this.heap = new ArrayList<>(items);
        builMinHeap(heap);
    }

    /**
     * @param i
     * @return
     */
    protected int parentId(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param i
     * @return
     */
    protected int leftId(int i) {
        return 2 * i + 1;
    }

    /**
     * @param i
     * @return
     */
    protected int rightId(int i) {
        return 2 * i + 2;
    }

    /**
     * @param j
     * @return
     */
    protected boolean hasLeft(int j) {
        return leftId(j) < heap.size();
    }

    /**
     * @param j
     * @return
     */
    protected boolean hasRight(int j) {
        return rightId(j) < heap.size();
    }

    /**
     * @return
     */
    public int size() {
        return heap.size();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @param h
     * @param i
     * @param j
     */
    public static void swap(ArrayList<Integer> h, int i, int j) {
        Collections.swap(h, i, j);
    }

    /**
     * @param h
     * @param i
     * @param heapsize
     */
    public void heapify(ArrayList<Integer> h, int i, int heapsize) {
        int l = leftId(i);
        int r = rightId(i);
        int minimo;

        if (l <= heapsize && h.get(l) < h.get(i)) {
            minimo = l;

        } else {
            minimo = i;
        }

        if (r <= heapsize && h.get(r) < h.get(minimo)) {
            minimo = r;
        }

        if (minimo != i) {
            swap(h, i, minimo);
            heapify(h, minimo, heapsize);
        }
    }

    /**
     * @param h
     */
    public void builMinHeap(ArrayList<Integer> h) {
        int heapsize = h.size() - 1;
        for (int i = heapsize / 2; i >= 0; i--) {
            heapify(h, i, heapsize);
        }
    }

    /**
     * @param h
     * @param i
     */
    private void heapIncreaseKey(ArrayList<Integer> h, int i) {
        while (i > 0 && heap.get(i) < heap.get(parentId(i))) {
            swap(heap, i, parentId(i));
            i = parentId(i);
        }
    }

    /**
     * @param key
     */
    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;
        heapIncreaseKey(heap, i);
    }

    /**
     * @return
     */
    public Integer min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * @return
     */
    public Integer removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Integer answer = heap.get(0);
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(heap, 0, heap.size() - 1);
        return answer;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
      MinHeap heap = new MinHeap();
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(15);
        heap.insert(9);
        heap.insert(7);
        heap.insert(20);
        heap.insert(16);
        heap.insert(25);
        heap.insert(14);
        heap.insert(12);
        heap.insert(11);
        heap.insert(13);
        System.out.println(heap); // [4, 5, 6, 15, 9, 7, 20, 16, 25, 14, 12, 11, 13]
        Integer min = heap.min();
        System.out.println(min); // 4

        Integer removedMin = heap.removeMin();
        System.out.println(removedMin); // 4
        System.out.println(heap); // [5, 9, 6, 15, 12, 7, 20, 16, 25, 14, 13, 11]

        Integer min2 = heap.removeMin();
        System.out.println(min2); // 5
        System.out.println(heap); // [6, 9, 7, 15, 12, 11, 20, 16, 25, 14, 13]
    }
}
