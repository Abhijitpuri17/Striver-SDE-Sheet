import java.util.ArrayList;

public class Solution 
{
	public static int maximumProduct(ArrayList<Integer> arr, int n) 
    {
		int ans = Integer.MIN_VALUE ;
        
        int curr = 1 ;
        
        for (int i = 0 ; i < n; i++)
        {
            curr *= arr.get(i) ;
            ans = Math.max(ans, curr) ;
            if (curr == 0){
                curr = 1 ;
            }
        }
        
        curr = 1 ;
        
        for (int i = n-1; i >= 0; i--)
        {
            curr *= arr.get(i) ;
            ans = Math.max(ans, curr) ;
            if (curr == 0){
                curr = 1 ;
            }
        }
        
         return ans ;
	}
    
   
}
