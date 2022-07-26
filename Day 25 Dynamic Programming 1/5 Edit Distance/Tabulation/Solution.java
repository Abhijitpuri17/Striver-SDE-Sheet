public class Solution 
{
    public static int editDistance(String word1, String word2) 
    {
        int m = word1.length(), n = word2.length() ;
        
        int[][] dp = new int[m+1][n+1] ;
        
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if(i == 0)
                    dp[i][j] = j ;
                else
                if (j == 0)
                    dp[i][j] = i ;
                else
                if (word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] ;
                }
                else
                {
                    int insert = dp[i][j-1] + 1 ;
                    int del = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1 ;
                    
                    dp[i][j] = Math.min(insert, Math.min(del, replace)) ;
                }
            }
        }
        
        return dp[m][n] ;
    }
}
