import java.util.* ;
public class Solution 
{

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        Arrays.sort(positions) ;
        int low  = 1, high = positions[n-1] - positions[0] ;
        
        int ans = 0 ;
        while (low <= high)
        {
            int mid = low + ((high-low)>>1) ;
          
            if (canPlace(positions, n, c, mid))
            {
                ans = mid ;
                low = mid + 1;
            }
            else
            {
                high = mid - 1 ;
            }
        }
        
        return ans ;
        
    }

    public static boolean canPlace(int[] positions, int n, int c, int dist)
    {
        int players = 1 ;
        int lastPos = positions[0] ;
        
        for (int i = 1 ; i < n; i++)
        {
            if (positions[i] - lastPos >= dist)
            {
                players++ ;
                lastPos = positions[i] ;
            }
        }
        
        return players >= c ;
    }
    
}
