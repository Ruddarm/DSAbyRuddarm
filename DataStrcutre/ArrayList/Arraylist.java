package DSAbyRuddarm.DataStrcutre.ArrayList;
// import array list
import java.util.ArrayList;;
public class Arraylist {
    public static void main(String[] args) {
        // define arraylist of integers
        ArrayList<Integer>  list = new ArrayList<>();
        // Add element in list O(1)
        list.add(1);
        list.add(2);
        list.add(3);
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
    }
}
