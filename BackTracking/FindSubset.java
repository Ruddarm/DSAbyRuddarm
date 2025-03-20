package DSAbyRuddarm.BackTracking;

public class FindSubset {
    public static void main(String[] args) {
       
        String str = "abc";
        findSubset(0, str, "");

    }
    public static void findSubset(int idx, String arr, String str){
        if(idx==arr.length()){
            System.out.println(str);
            return;
        };
        
        findSubset(idx+1,arr,str+arr.charAt(idx));
        findSubset(idx+1,arr,str);

    }

 
}
