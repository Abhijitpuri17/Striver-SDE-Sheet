import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        int maxLen = 0 ;
        int arrLen = arr.size() ;
       
        HashMap<Integer, Integer> firstIndex = new HashMap<>() ;
        
        int preSum = 0 ;
       
        for (int i = 0 ; i < arrLen; i++)
        {
            preSum += arr.get(i) ;
            
            if (preSum == 0) {
                maxLen = i + 1 ;
            }
            else
            if (firstIndex.containsKey(preSum))
            {
                int currLen = i - firstIndex.get(preSum) ;
                maxLen = Math.max(maxLen, currLen) ;  
            } else firstIndex.put(preSum, i) ;    
        }
        
        return maxLen ;
        
	}
}
