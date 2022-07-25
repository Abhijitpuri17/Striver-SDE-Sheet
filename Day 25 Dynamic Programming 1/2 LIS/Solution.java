
public class Solution 
{

	public static int longestIncreasingSubsequence(int arr[]) 
    {
        int n = arr.length ;
		    int[] dp = new int[n] ;
        
        int ans = 0 ;
        
        for (int i = 0 ; i < n; i++)
        {
            dp[i] = 1 ;
            for (int j = 0; j <  i; j++)
            {
                if (arr[i] > arr[j])
                dp[i] = Math.max(dp[i], dp[j] + 1) ; 
            }
            ans = Math.max(ans, dp[i]) ;
        }
        
        return ans ;
	}
    
    

}
