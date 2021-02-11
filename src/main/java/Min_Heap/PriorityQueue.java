package Min_Heap;

import Min_Heap.MinHeap.Entry;

public interface PriorityQueue {
    int size();
    boolean isEmpty();
    Entry insert(int key, String value) throws IllegalArgumentException;
    Entry min();
    Entry removeMin();
}
