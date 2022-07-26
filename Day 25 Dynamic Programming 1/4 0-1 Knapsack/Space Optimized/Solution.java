import java.util.ArrayList;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) 
    {
        int[] dp = new int[w+1] ;
        
        for (int i = 1; i <= n ; i++)
        {
            for (int wt = w ; wt >= 0; wt--)
            {
                int incl = 0, excl = 0;
                excl = dp[wt] ;
                if (wt >= weights.get(i-1))
                {
                    incl = dp[wt - weights.get(i-1)] + values.get(i-1);
                }
                dp[wt] = Math.max(incl, excl) ;
            }
           
        }
        
        return dp[w] ;
	}
    
    
}
