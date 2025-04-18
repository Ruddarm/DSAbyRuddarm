package DSAbyRuddarm.DataStrcutre.ArrayList;
// import array list
import java.util.ArrayList;
import java.util.Collections;;
public class Arraylist {
    public static void main(String[] args) {
        // define arraylist of integers
        ArrayList<Integer>  list = new ArrayList<>();
        // Add element in list O(1)
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(10);
        list.add(2);

        System.out.println("Added Element in list \n"+list);
        // Add element at index 1 O(n)
        list.add(1,10);
        System.out.println("Added Element at index 1 \n"+list);
        // get element at index 1 O(1)
        System.out.println("Get Element at index 2 \n"+list.get(2));
        // set element at index 1 O(1)
        list.set(1,20);
        System.out.println("Set Element at index 1 \n"+list);
        // remove element at index 1 O(n)
        list.remove(1);
        System.out.println("Remove Element at index 1 \n"+list);
        // contianse element
        System.out.println("Contains Element 2 \n"+list.contains(2));
        // size of list O(1)
        System.out.println("Size of list \n"+list.size());
        // traverse list O(n)
        System.out.println("Traverse list \n");
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        // finding maximum from list
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < list.size(); i++){
            max = Math.max(max, list.get(i));
        }
        System.out.println("\nMaximum Element in list \n"+max);
        // sorting list O(nlogn)
        Collections.sort(list);  // time complexity O(nlogn)    
        System.out.println("Sorted list \n"+list);
        // sorting in reverse order O(nlogn)
        Collections.sort(list, Collections.reverseOrder()); // time complexity O(nlogn)    
        System.out.println("Sorted list in reverse order \n"+list); 

    }
}
