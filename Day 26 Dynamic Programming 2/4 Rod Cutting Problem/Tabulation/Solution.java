public class Solution 
{
	public static int cutRod(int price[], int n) 
  {
    int[] dp = new int[n+1] ;
        
    dp[0] = 0 ;
        
    for (int i = 1; i <= n ; i++)
    {
      for (int j = 1; j <= i; j++)
      {
        dp[i] = Math.max(dp[i], price[j-1] + dp[i-j]);
      }
    }
       
    return dp[n]  ;
	}    
}
