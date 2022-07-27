
public class Solution
{
    public static long countWaysToMakeChange(int denominations[], int value)
    {
        int n = denominations.length ;
        return helper(denominations, n-1, value, new long[n+1][value+1])  ;
    }
    
    public static long helper(int[] denom, int ind, int val, long[][] dp)
    {
        if (val == 0)
            return 1 ;
        
        if (ind < 0 || val < 0)
            return 0 ;
        
        if (dp[ind][val] != 0)
            return dp[ind][val] ;
        
        long notTake = helper(denom, ind - 1, val, dp) ;
        long take = helper(denom, ind, val - denom[ind], dp) ;
        
        return dp[ind][val] = take + notTake ;
    }
    
}
