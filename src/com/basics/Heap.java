package com.basics;

import java.util.List;
import java.util.ArrayList;

public class Heap {
    // leftChild = heap[2 * i]
    // rightChild = heap[(2 * i) + 1]
    // parent = heap[i // 2]
    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void push(int val) {
//        add value to heap for a start
        heap.add(val);

//        get last index
        int i = heap.size() - 1;

        // Percolate up
//        keep moving the value up if the parent has a greater value for a min heap
        while ((i > 1) && (heap.get(i) < heap.get(i / 2))) {
//            Swap with parent
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i = i / 2;
        }
    }

    public int pop() {
        if (heap.size() == 1) {
            throw new IllegalStateException("Heap is empty");
        }

        if (heap.size() == 2) {
//            remove and return the root(only element in heap)
            return heap.remove(1);
        }

//        get the current min
        int res = heap.get(1);

        // Move last value to root
        heap.set(1, heap.remove(heap.size() - 1));


        // leftChild = heap[2 * i]
        // rightChild = heap[(2 * i) + 1]
        // Percolate down
        int i = 1;

//        check if there is a left child
        while((2 * i) < heap.size()) {
            if (
//                    check for presence of right child
                    ((2 * i) + 1) < heap.size() &&
//                            check if right value is less than left
                    heap.get(2 * i + 1) < heap.get(2 * i) &&
//                            check if right value is less than curr value
                    heap.get(2 * i + 1) < heap.get(i)
            ) {
                // Swap right child if less than current parent
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                // Swap left child if less than current parent
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }

        return res;
    }
}
