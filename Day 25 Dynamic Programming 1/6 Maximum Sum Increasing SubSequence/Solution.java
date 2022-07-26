import java.util.ArrayList;

public class Solution 
{
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) 
    {
        int[] dp = new int[n] ;
        
        int ans = 0;
        
        for (int i = 0 ; i < n; i++)
        {
            int prev = 0;
            for (int j = 0 ; j < i; j++)
            {
                if (rack.get(i) > rack.get(j))
                {
                    prev = Math.max(prev, dp[j]) ;
                }
            }
            dp[i] = prev + rack.get(i) ;
            
            ans = Math.max(ans, dp[i]) ;
        }
        
        return ans ;
    }
}
