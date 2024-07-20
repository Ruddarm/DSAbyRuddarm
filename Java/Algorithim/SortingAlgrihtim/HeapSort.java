package DSAbyRuddarm.Java.Algorithim.SortingAlgrihtim;

import java.lang.reflect.Array;
import java.util.ArrayList;

import DSAbyRuddarm.Java.DSImplementations.MaxHeap;

public class HeapSort {
    public static void main(String[] args) {
        Integer arr[]={5,4,2,6,1,3};
        MaxHeap heap = new MaxHeap<Integer>(arr);
        heap.heapSort();
        ArrayList<Integer> ans = heap.getheap();
        for(int i : ans){
            System.err.println(i);
        }
    }
}
