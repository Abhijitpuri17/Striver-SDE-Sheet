import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
    
		    long maxSum = 0 ;
        long currSum = 0 ;
        
        for (int num : arr)
        {
            currSum += num ;
            maxSum = Math.max(maxSum, currSum) ;
            
            currSum = Math.max(currSum, 0) ;
        }
        
        return maxSum ;
        
	}

}
