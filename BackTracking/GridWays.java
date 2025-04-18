package DSAbyRuddarm.BackTracking;

public class GridWays {
    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countWays(n, m));
    }
    static int countWays(int n , int m ){
        // base case
        if( n <= 0 || m <= 0){
            return 0;
        }
        // if we reach the destination cell
        // then we return 1
        if( n == 1 &&  m == 1){
            return 1;
        }
        return countWays(n-1, m) + countWays(n, m-1);

    }
}
