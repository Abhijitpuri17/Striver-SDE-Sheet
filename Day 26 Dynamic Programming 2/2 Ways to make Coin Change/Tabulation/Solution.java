
public class Solution
{
    public static long countWaysToMakeChange(int denominations[], int value)
    {
        int n = denominations.length ;
        
        int[][] dp = new int[n+1][value+1] ;
        
        for (int ind = 0; ind <= n; ind++)
            dp[ind][0] = 1 ;
        
        for (int ind = 1; ind <= n; ind++)
        {
            for (int val = 1; val <= value; val++)
            {
                int notTake = dp[ind - 1][val] ;
                
                int take = 0 ;
                
                if (denominations[ind-1] <= val)
                {
                    take = dp[ind][val - denominations[ind-1]] ;
                }
                
                dp[ind][val] = take + notTake ;
            }
        }
              
        return dp[n][value] ;
  
    }
  
    
}
