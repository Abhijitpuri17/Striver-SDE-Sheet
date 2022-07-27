public class Solution 
{
  public static int cutRod(int price[], int n) 
  { 
		return helper(price, n, new int[n+1]) ;
  }
    
  static int helper(int[] price, int n, int[] dp)
  {
    if (n <= 0) return 0 ;
        
    if (dp[n] != 0) return dp[n] ;
        
    int profit = 0 ;
       
    for(int cut = 1; cut <= n ; cut++)
    {
      profit = Math.max(profit, 
                        price[cut - 1] + helper(price, n - cut, dp)) ;
    }
       
    return dp[n] = profit ;
  }  
}
