package Max_Heap;

import Max_Heap.MaxHeap.Entry;

public interface PriorityQueue {
    int size();
    boolean isEmpty();
    Entry insert(int key, String value) throws IllegalArgumentException;
    Entry insert(Entry entry);
    Entry max();
    Entry removeMax();
}
