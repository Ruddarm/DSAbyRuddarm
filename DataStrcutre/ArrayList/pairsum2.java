package DSAbyRuddarm.DataStrcutre.ArrayList;

import java.util.ArrayList;
public class pairsum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum(list, target));

    }
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int pivot = -1;
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                pivot = i;
                break;
            }
        }
        int left = (pivot + 1) % list.size();
        int right = pivot;
        while(left != right){
            int sum = list.get(left) + list.get(right);
            if(sum == target){
                return true;
            }
            if(sum < target){
                left = (left + 1) % list.size();
            }else{
                right = (right - 1 + list.size()) % list.size();
            }
        }
        return false;
    }
}
