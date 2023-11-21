package com.basics;

public class PowerOfTwoMaxHeap {
    private int[] heap;
    private int size;
    private final int childFactor;

    public PowerOfTwoMaxHeap(int childFactor) {
        if (childFactor <= 0) {
            throw new IllegalArgumentException("Child Factor must be greater than 0");
        }
        this.childFactor = childFactor;
//        set initial size to account for a parent and complete children
        heap = new int[(int) Math.pow(2, childFactor) + 1];
    }

    public static void main(String[] args) {
        // Create a heap with child factor of 2
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2);

        heap.insert(5);
        heap.insert(3);
        heap.insert(9);
        heap.insert(2);
        heap.insert(7);

        // Pop max element
        System.out.println("Max element: " + heap.popMax()); // Output: 9
        System.out.println("Max element: " + heap.popMax()); // Output: 7
        System.out.println("Max element: " + heap.popMax()); // Output: 5

        // Create heap with degree 3
        PowerOfTwoMaxHeap heap2 = new PowerOfTwoMaxHeap(3);

        // Insert elements
        heap2.insert(10);
        heap2.insert(8);
        heap2.insert(15);
        heap2.insert(12);
        heap2.insert(20);

        // Pop max element
        System.out.println("Max element: " + heap2.popMax()); // Output: 20
        System.out.println("Max element: " + heap2.popMax()); // Output: 15
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
            } else break;
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

    public int popMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

//        Get the max value
        int max = heap[0];

//        Move last element to top of heap
        heap[0] = heap[--size];

//        Heapify down to maintain heap properties
        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int index) {
        int maxIndex = index;

//        Loop through all children
        for (int i = 1; i <= childFactor; i++) {
            int childIndex = index * childFactor + i;

//          check that childindex is present in heap and has a greater value than current max
            if ((childIndex < size) && heap[childIndex] > heap[maxIndex]) {
                maxIndex = childIndex;
            }
        }

//        if maxindex was updated, then swap and heapifydown the new max
        if (maxIndex != index) {
            swap(maxIndex, index);
            heapifyDown(maxIndex);
        }
    }
}
