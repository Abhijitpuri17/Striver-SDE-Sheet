import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        
        HashSet<Integer> set = new HashSet<>() ;
        
        for (int num : arr)
        {
            set.add(num) ;
        }
        
        int ans = 0 ;
        
        for (int num : arr)
        {
            if (set.contains(num-1)) continue ;
            
            int curr = num ;
            int count = 0 ;
            
            while (set.contains(curr)) {
                curr++ ;
                count++ ;
            }
            
            ans = Math.max(count, ans) ;
        }
        
        return ans ;
    }
}
