import java.util.ArrayList;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) 
    {
        int[][] dp = new int[n+1][w+1] ;
        
        for (int i = 1; i <= n ; i++)
        {
            for (int wt = 0 ; wt <= w; wt++)
            {
                int incl = 0, excl = 0;
                excl = dp[i-1][wt] ;
                
                if (wt >= weights.get(i-1))
                {
                    incl = dp[i-1][wt - weights.get(i-1)] + values.get(i-1);
                }
                
                dp[i][wt] = Math.max(incl, excl) ;
            }
        }
        
        return dp[n][w] ;
	}
    
    
}
