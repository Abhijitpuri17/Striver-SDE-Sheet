public class Solution 
{
	public static boolean subsetSumToK(int n, int k, int[] arr)
  {
		return f(arr, k, arr.length-1, new int[n][k+1]) ;  
	}
    
    public static boolean f(int[] arr, int k, int i, int[][] dp)
    {
        if (i == -1) {
            return k == 0 ;
        } 
        
        if (k < 0) return false ;
        
        if (dp[i][k] != 0) return dp[i][k] == 1 ;
        
        boolean incl = f(arr, k - arr[i], i-1, dp) ;
        boolean excl = f(arr, k, i-1, dp) ;
   
        
        if (incl || excl) dp[i][k] = 1 ;
        else dp[i][k] = -1 ;
        
        return incl | excl ;
   
    }
    
}
