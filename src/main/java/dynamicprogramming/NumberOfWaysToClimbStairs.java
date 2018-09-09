package dynamicprogramming;

public class NumberOfWaysToClimbStairs {

  /*
   * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
   * Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? 
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

 Answer:
 For 0 stairs and 0 steps there is 1 way
 For 1 stairs and 1 step there is 1 way
 For 2 stairs and 1 step there is 1 way..
  For 2 stairs and 2 step there is 1 way..
  So total is 2 ways
  


   */
  public static int findWays(int stairs, int[] steps) {
    int[] response = new int[stairs+1] ;
    response[0] = 1 ;
    response[1] = 1 ;
    for(int i=2;i<=stairs;i++) {
      for(int j=0;j<steps.length;j++) {
        
        int step = steps[j] ;
        if(i>=step) {
          response[i] = response[i] + response[i-step] ;
        }
      }
    }
    for(int i = 0 ;i<response.length;i++) {
      System.out.print(response[i]+", ");
    }
    System.out.println();
    return response[stairs] ;
  }
  
  public static void main(String[] args) {
    int stairs = 5 ;
    int[] steps  = {1,3,5} ;
    int ways = findWays(stairs, steps) ;
    System.out.println("total number of ways = "+ways);
  }
}
