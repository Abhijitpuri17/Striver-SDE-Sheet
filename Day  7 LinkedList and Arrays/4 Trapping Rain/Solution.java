import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        int start = 0, end = n - 1 ;
        
        long leftMax = Long.MIN_VALUE ;
        long rightMax = Long.MIN_VALUE ;
        
        long ans = 0 ;
        
        while (start < end)
        {
            if (arr[start] < arr[end])
            {
                leftMax = Math.max(leftMax, arr[start]) ;
                ans += leftMax - arr[start] ;
                start++ ;
            } else{
                rightMax = Math.max(rightMax, arr[end]) ;
                ans += rightMax - arr[end] ;
                end-- ;
            }
        }
        
        return ans ;
    }
}
