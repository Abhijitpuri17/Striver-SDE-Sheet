// O(n^2) Solution

import java.util.ArrayList;

public class Solution 
{
	public static int maximumProduct(ArrayList<Integer> arr, int n) 
    {
		int ans = Integer.MIN_VALUE ;
        
        for (int i = 0 ; i < n; i++)
        {
            int curr = 1 ;
            int max = Integer.MIN_VALUE ;
            for (int j = i ; j < n; j++)
            {
                curr *= arr.get(j) ;
                //System.out.println()
                ans = Math.max(ans, curr) ;
            }
        }
        
         return ans ;
	}
    
   
}
