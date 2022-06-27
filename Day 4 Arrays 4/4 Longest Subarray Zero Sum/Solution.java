import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        int maxLen = 0 ;
        int arrLen = arr.size() ;
        
        for (int i = 0 ; i < arrLen ; i++)
        {
            int currSum = 0 ;
            for (int j = i; j < arrLen; j++)
            {
                currSum += arr.get(j) ;
                if (currSum == 0) {
                    int currLen = j - i + 1 ;
                    maxLen = Math.max(currLen, maxLen) ;
                }
            }
        }
        
        return maxLen ;
        
	}
}
