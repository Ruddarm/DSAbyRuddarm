package DSAbyRuddarm.DataStrcutre.ArrayList;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1); 
         heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4); 
        heights.add(8);
        heights.add(3);
        heights.add(7);
        System.out.println(maxArea(heights));   
    }
    public static int maxArea(ArrayList<Integer> heights){
        int maxWater  = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.size() - 1;
        while (left<right){
            int width = right - left;
            int height = Math.min(heights.get(left), heights.get(right));
            int area = width * height;
            maxWater = Math.max(maxWater, area);
            if (heights.get(left) < heights.get(right)){
                left++;
            }else{
                right--;
            }
            
        }
        return maxWater;
    }
}
