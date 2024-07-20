package DSAbyRuddarm.Java.DSImplementations;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> {
    public ArrayList<T> heap;
    private int size;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    public MaxHeap(T array[]) {
        this.heap =  new ArrayList<>();
        for (T val : array) {
            heap.add(val);
        }
        this.size = this.heap.size();

    }

    public void build_MaxHeap() {
        int i = 0;
        for (i = (this.size / 2) - 1; i >= 0; i--) {
            this.HeapifyDown(i);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(T val) {
        this.heap.add(val);
        this.size++;
        this.HeapifyUp(size - 1);
    }

    public void HeapifyUp(int index) {
        int parent = (index - 1) / 2;
        T val = this.heap.get(index);
        while (index > 0 && val.compareTo(heap.get(parent)) > 0) {
            this.heap.set(index, heap.get(parent));
            index = parent;
            parent = (index - 1) / 2;
        }
        this.heap.set(index, val);

    }
    public void heapSort(){
        build_MaxHeap();
        for (int i = this.size-1;i<=1;i--){
            T temp= this.heap.get(1);
            this.heap.set(1, this.heap.get(i));
            this.heap.set(i, temp);
            this.size-=1;
            this.HeapifyDown(i);
        }
    }
    public ArrayList<T> getheap(){
        return this.heap;
    }

    public void HeapifyDown(int index) {
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;
        int largest = index;
        if (left < heap.size() && (this.heap.get(left).compareTo(this.heap.get(index)) > 0)) {
            largest = left;
        }
        if (right < this.heap.size() && (this.heap.get(right).compareTo(this.heap.get(index)) > 0)) {
            largest = right;
        }
        if (largest != index) {
            T temp = heap.get(index);
            this.heap.set(index, this.heap.get(largest));
            this.heap.set(largest, temp);
            this.HeapifyDown(largest);
        }
    }

    public T peek() {
        if (this.heap.isEmpty()) {
            throw new NoSuchElementException("Heap is Empty");
            // return null;
        }
        return this.heap.get(0);
    }

    public T DeleteMax() {
        if (this.heap.isEmpty()) {
            throw new NoSuchElementException("Heap is Empty");
            // return null;
        }
        T maxValue = this.heap.get(0);
        T lastValue = this.heap.remove(this.size-1);
        this.size--;
        if(!this.heap.isEmpty()){
            this.heap.set(0, lastValue);
            this.HeapifyDown(0);
        }
        return maxValue;

    }

}
