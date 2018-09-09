package dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a set of infinite supply of coins,
 * find the number of ways to make a particular sum. 
 * Answer: This can be done by making a memoization matrix
 * The columns are total sum
 * The rows are coins 
 * 
 * 1. Add the number of ways without the new coin
 * 2. Add the number of ways by always including the new coin
 * 3. Add 1 & 2
 * 
 * https://www.youtube.com/watch?v=PafJOaMzstY&t=386s
 */
public class CoinProblem {
  
  public static int getNumberOfWays(int total, int[] coins) {
      int[][] numberOfWays = new int[coins.length][total+1] ;
      for(int i = 0;i<coins.length;i++) {
        for(int j=0;j<=total;j++) {
          if(i==0 && j==0) {
            numberOfWays[i][j] = 1 ;
          } else {
            if(i>j) {
              numberOfWays[i][j] = numberOfWays[i-1][j] ;
            } else {
              int waysByExcludingTheCoin  = 0;
              int waysByIncludingTheCoin = 0 ;
              if(i>0) {
                waysByExcludingTheCoin = numberOfWays[i-1][j] ;
              }
                  
              if((j-i)>=0) {
                waysByIncludingTheCoin = numberOfWays[i][j-i] ;
              }
              numberOfWays[i][j] = waysByExcludingTheCoin+waysByIncludingTheCoin ;
            }
          }
        }
      }
      
      for(int i=0;i<coins.length;i++) {
        System.out.println();
        for(int j=0;j<=total;j++) {
          System.out.print(numberOfWays[i][j] + ", ");
        }
      }
      System.out.println();
      return numberOfWays[coins.length-1][total] ;
  }

  
  public static void main(String[] args) {
    int total = 5;
    int[] coins = {0,1,2,3,4,5} ;
     int ways = getNumberOfWays(total, coins) ;
     System.out.println("number of ways = "+ways);
  }

}
