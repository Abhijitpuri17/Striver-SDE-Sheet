
public class Solution 
{
	public static int matrixMultiplication(int[] arr , int N)
  {
		return helper(arr, 1, N-1, new int[N+1][N+1]) ;
	}
    
    static int helper(int[] arr, int i, int j, int[][] dp)
    {
        if (i == j)
            return 0 ;
        
        if (dp[i][j] != 0)
            return dp[i][j] ;
        
        int min = Integer.MAX_VALUE ;
        for (int k = i; k < j; k++)
        {
            int val = arr[i-1] * arr[k] * arr[j] + helper(arr, i, k, dp) + helper(arr, k+1, j, dp);
            min = Math.min(val, min) ;
        }
        
        return dp[i][j] = min ;
    }
    
}
