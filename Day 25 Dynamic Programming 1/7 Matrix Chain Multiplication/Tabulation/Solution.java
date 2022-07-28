
public class Solution 
{
	public static int matrixMultiplication(int[] arr , int N)
    {
        int[][] dp = new int[N+1][N+1] ;
        
        for (int i = N-1; i > 0; i--)
        {
            for (int j = i + 1; j < N; j++)
            {
                int min = Integer.MAX_VALUE ;
                for (int k = i; k < j; k++)
                {
                    int val = arr[i-1] * arr[k] * arr[j] ;
                    val += dp[i][k] + dp[k+1][j] ;
                    
                    min = Math.min(val, min) ;
                }
                dp[i][j] = min ;
            }
        }
      
        return dp[1][N-1] ;
        
	}
     
}
