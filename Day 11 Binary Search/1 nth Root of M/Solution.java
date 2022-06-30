public class Solution {
    
    public static double findNthRootOfM(int n, long m) {
    
        double low = 0 , high = m*1.0 ;
        double ans = 0.0 ;
        int cnt = 80 ;
        
        //while(high-low > 1e-8)
        while (cnt-- > 0)
        {
            double mid = (high + low) / 2 ;
            double prod = 1.0 ;
            
            for (int i = 0 ; i < n ; i++)
            {
                prod *= mid ;
            }
            if (prod > m)
            {
                high = mid;
            } else {
                low = mid ;
                ans = mid ;
            }
        }
        
        return ans ;
    }
    
}
