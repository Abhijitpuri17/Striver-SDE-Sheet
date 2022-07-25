import java.util.ArrayList;

public class Solution 
{
	public static int maximumProduct(ArrayList<Integer> arr, int n) 
    {
        int min = arr.get(0) ;
        int max = arr.get(0);
        int ans = arr.get(0) ;
        
        for (int i = 1 ; i < n; i++)
        {
            int temp = max ;
            max = Math.max(
                temp*arr.get(i),
                
                Math.max(
                    min*arr.get(i),
                    arr.get(i)
                )
                
            );
            
            min = Math.min(
                temp*arr.get(i),
                
                Math.min(
                    min*arr.get(i),
                    arr.get(i)
                )
                
            );
            
            ans = Math.max(ans, max) ;
        }
     
        return ans ;
	}
}
