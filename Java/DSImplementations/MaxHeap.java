package DSAbyRuddarm.Java.DSImplementations;
import java.util.ArrayList;
public class MaxHeap <T extends Comparable<T>> {
    private ArrayList<T> heap;
    private int size;
    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.size=0;
    }
    public MaxHeap(int array[]){

    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void insert(T val){
        this.heap.add(val);
    }
    public void HeapifyUp(int index){
        int parent = (index-1)/2;
        T val = this.heap.get(index);
        


    }
    public void HeapifyDown(){

    }
    
}
