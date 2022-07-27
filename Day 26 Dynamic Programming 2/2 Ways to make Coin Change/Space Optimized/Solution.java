
public class Solution
{
    public static long countWaysToMakeChange(int denominations[], int value)
    {
        int n = denominations.length ;
        
        long[] dp = new long[value+1] ;
        
        dp[0] = 1 ;
        
        for (int ind = 1; ind <= n; ind++)
        {
            for (int val = 1; val <= value; val++)
            {
                long notTake = dp[val] ;
                
                long take = 0 ;
                
                if (denominations[ind-1] <= val)
                {
                    take = dp[val - denominations[ind-1]] ;
                }
                
                dp[val] = take + notTake ;
            }
        }
       
        return dp[value] ;
        
    }
        
}
