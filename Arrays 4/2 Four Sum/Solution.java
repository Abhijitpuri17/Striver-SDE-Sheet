import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      
      Arrays.sort(arr) ;
      
      for (int i = 0 ; i < n ; i++)
      {
          for (int j = i+1; j < n; j++)
          {
              int req = target - arr[i] - arr[j] ;
              
              int start = j + 1, end = n - 1 ;
              
              while (start < end)
              {
                  if (arr[start] + arr[end] == req) return "Yes" ;
                  
                  if (arr[start] + arr[end] < req) start++ ;
                  else end-- ;
              }
                
          }
      }
      
      return "No" ;  
  }
}
