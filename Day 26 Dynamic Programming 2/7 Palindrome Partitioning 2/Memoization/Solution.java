public class Solution
{
	public static int palindromePartitioning(String str) 
    {
        int n = str.length() ;
        return helper(str, 0, n, new int[n+1][n+1]);
	}
    
    static int helper(String str, int i, int j, int[][] dp)
    {
        if (isPalindrome(str, i, j))
            return 0 ;
        
        if (dp[i][j] != 0)
            return dp[i][j] ;
        
        int min = Integer.MAX_VALUE ;
        
        for (int k = i+1; k <= j; k++)
        {
            if (isPalindrome(str, i, k)) 
            {
               int curr = 1 + helper(str, k, j, dp) ;
               min = Math.min(curr,  min) ;
            }
        }
        
        return dp[i][j] = min;
    }
    
    
    static boolean isPalindrome(String s, int start, int end)
    {
        end-- ;
        while(start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                return false ;
            }
            start++ ;
            end-- ;
        }
        
        return true ;
    }
    
}
