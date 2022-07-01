public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) 
    {
        long low = Long.MIN_VALUE;
        long high = (long)1e14 ;
        
        for (int t: time) low = Math.max(low, t) ;
        
        long ans = -1 ;
        while (low <= high)
        {
            long mid = low + ((high-low)>>1) ;
            
            if (canComplete(mid, time, m, n))
            {
                ans = mid ;
                high = mid - 1;
            }
            else 
            {
                low = mid + 1 ;
            } 
        }
        
        return ans ;
    }
    
    public static boolean canComplete(long perDay, int[] time, int n, int days)
    {
        long reqDays = 1 ;
        long curr = 0 ;
        for (int i = 0 ; i < n; i++)
        {
           curr += time[i] ;
           if (curr > perDay)
           {
               reqDays++ ;
               curr = time[i] ;
           }
        }
        
        return reqDays <= days ;
    }
    
}
