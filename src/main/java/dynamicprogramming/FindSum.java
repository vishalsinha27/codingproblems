package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class FindSum {

  /*
   * use extra memory....
   * Is the array sorted - What if sort the array.
   * 1,2,3,20,21,22,29,34,50 k= 41
   * sorting wont help
   * 12,
   *  1,2,3,11,12,14,23,53,90    13
   */
  public static boolean addUp(int[] array, int k) {
    if(array.length==0) {
      return false ;
    }
    
    HashMap<Integer, Boolean> remainder = new HashMap<Integer, Boolean>();
    for(int a : array) {
      int r = k -a ;
      if(remainder.containsKey(a)) {
        System.out.println("matching "+a +" and " + r);
        return true ;
      }
      remainder.put(r, true) ;
    }
    return false ;
  }
  
  
  public static boolean containsPairWithSum(int[] a, int x) {
    Arrays.sort(a);
    for (int i = 0, j = a.length - 1; i < j;) {
        int sum = a[i] + a[j];
        if (sum < x)
            i++;
        else if (sum > x)
            j--;
        else
            return true;
    }
    return false;
}
  public static void main(String[] args) {
    int[] test1 = {1,2,3,32,14,23,80,11,90,12} ;
    int k  = 103 ;
    //System.out.println(addUp(test1, k));
    System.out.println(containsPairWithSum(test1, k));

  }
}
