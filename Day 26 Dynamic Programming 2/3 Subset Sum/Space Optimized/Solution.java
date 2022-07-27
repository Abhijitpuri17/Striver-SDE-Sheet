public class Solution 
{
	public static boolean subsetSumToK(int n, int k, int[] arr)
  {
        boolean[] dp = new boolean[k+1] ;
        
        for (int i = 0 ; i < n ; i++) dp[0] = true ;
        
        for (int i = 1 ; i <= n ; i++)
        {
            for (int j = k ; j >= 0 ; j--)
            {
                boolean incl = false, excl = false ;
                if (arr[i-1] <= j) {
                    incl = dp[j - arr[i-1]] ;
                }
                excl = dp[j] ;
                dp[j] = incl | excl ;
            }
        }
        
        return dp[k] ;
	} 
}
