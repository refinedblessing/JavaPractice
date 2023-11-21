package com.basics;

public class PowerOfTwoMaxHeap {
    private int[] heap;
    private int size;
    private int childFactor;

    public PowerOfTwoMaxHeap(int childFactor) {
        this.childFactor = childFactor;
//        set initial size to account for a parent and complete children
        heap = new int[(int) Math.pow(2, childFactor) + 1];
    }

//    add value to heap
    public void insert(int value) {
        if (size == heap.length) {
            resize();
        }

        heap[size++] = value;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
//        while there is no parent node
        while (index > 0) {
            int parentIndex = (index - 1) / childFactor;
//            if current parent node is less than child node, swap
            if (heap[parentIndex] < heap[index]) {
                swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

}
