package Heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementazione di uno Heap tramite un ArrayList di Integer.
 */
public class HeapSort {

    // Capacità iniziale dell'ArrayList.
    public static int initialCapacity = 20;

    public static void main(String[] args) {

        ArrayList<Integer> heap = new ArrayList<>(initialCapacity);
        heap.add(20);
        heap.add(15);
        heap.add(10);
        heap.add(3);
        heap.add(8);
        heap.add(5);
        heap.add(6);
        heap.add(2);
        heap.add(1);
        System.out.println(heap.toString()); // [20, 15, 10, 3, 8, 5, 6, 2, 1]
        MaxHeapInsert(heap, 1);
        MaxHeapInsert(heap, 3);
        System.out.println(heap.toString()); // [20, 15, 10, 3, 8, 5, 6, 2, 1, 1, 3]
    }

    // Metodi per ottenere l'indice del nodo genitore oppure
    // il figlio sinistro/destro di un nodo di indice i.

    private static int parentId(int i) {
        return (i - 1) / 2;
    }

    private static int leftId(int i) {
        return 2 * i + 1;
    }

    private static int rightId(int i) {
        return 2 * i + 2;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Scambia l'elemento in posizione i con l'elemento in posizione j.
     *
     * @param h un ArrayList
     * @param i indice del primo elemento da scambiare
     * @param j indice del secondo elemento da scambiare
     */
    public static void swap(ArrayList<Integer> h, int i, int j) {
        Collections.swap(h, i, j);
    }

    /**
     * Inserisce l'elemento k in ultima posizione
     *
     * @param h un ArrayList
     * @param k l'elemento da inserire nello Heap
     */
    public static void MaxHeapInsert(ArrayList<Integer> h, int k) {
        int heapsize = h.size();
        if (heapsize < initialCapacity) {
            h.add(heapsize, k);
            int i = heapsize;

            while (h.get(i) > h.get(parentId(i))) {
                swap(h, i, parentId(i));
                i = parentId(i);
            }
        }
    }
}
