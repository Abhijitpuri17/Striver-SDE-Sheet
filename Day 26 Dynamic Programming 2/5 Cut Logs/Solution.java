import java.util.* ;
public class Solution {
    public static int dp[][];
    
    public static int cutLogs(int k, int n) 
    {
        dp = new int[10005][105];
        
        for(int i = 0; i < 10005; i++)
            Arrays.fill(dp[i], -1) ;
        
        return cut(n, k);
    }
    
    public static int cut(int n, int k)
    {
        if(k == 1)
            return n;
        
        if(n == 1 || n == 0)
            return n;
        
        if(dp[n][k] != -1)
            return dp[n][k];
        
        int ans = Integer.MAX_VALUE;
        
        int l = 1, h = n;
        
        while(l <= h)
        {
            int mid = l + ((h - l) >> 1) ;
            
            int a1 = cut(mid - 1, k - 1);
            
            int a2 = cut(n - mid, k);
            
            int temp = 1 + Math.max(a1, a2);
            
            if(a1 > a2)
                h = mid - 1 ;
            else
                l = mid + 1 ;
            
            ans = Math.min(ans, temp) ;
        }
        
        return dp[n][k] = ans;
    }

}
