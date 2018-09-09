package dynamicprogramming;

public class MaxSumOfNonAlternativeNumbers {

  public static int findSum(int[] data) {
    int internal = data[0] ;
    int external = 0 ;
    for(int i=1;i<data.length;i++) {
      int temp = internal ;
      internal = Math.max(internal, external+data[i]) ;
      external = temp ;
    }
    return internal ;
  }
  
  public static void main(String[] args) {
    int[] data = {1,2,3,4,6,7,8,1,2,34,1,0,-10};
    int maxSum = findSum(data) ;
    System.out.println("max sum is "+maxSum);
  }
}
