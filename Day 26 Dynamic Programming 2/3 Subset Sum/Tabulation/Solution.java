public class Solution 
{
	public static boolean subsetSumToK(int n, int k, int[] arr)
  {
        boolean dp[][] = new boolean[n+1][k+1] ;
        
        for (int i = 0 ; i < n ; i++) dp[i][0] = true ;
        
        for (int i = 1 ; i <= n ; i++)
        {
            for (int j = 0 ; j <= k ; j++)
            {
                boolean incl = false, excl = false ;
                if (arr[i-1] <= j) {
                    incl = dp[i-1][j - arr[i-1]] ;
                }
                excl = dp[i-1][j] ;
                dp[i][j] = incl | excl ;
            }
        }
        
        return dp[n][k] ;     
	}
}
