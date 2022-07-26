import java.util.ArrayList;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) 
    {
		return helper(values, weights, n, w, 0, new int[n+1][w+1]) ;
	}
    
    static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w, int ind, int[][] dp)
    {
        if (ind == values.size())
            return 0 ;
        if (dp[ind][w] != 0)
            return dp[ind][w] ;
        
        int incl = 0, excl = 0;
        
        excl = helper(values, weights, n, w, ind+1, dp) ;
        
        if (w >= weights.get(ind))
        {
            incl = helper(values, weights, n, w - weights.get(ind), ind+1, dp)
                + values.get(ind) ;
        }
        
        return dp[ind][w] = Math.max(incl, excl) ;
    }
    
    
}
