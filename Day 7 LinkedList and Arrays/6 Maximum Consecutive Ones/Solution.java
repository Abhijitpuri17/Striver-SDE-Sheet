import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		int start = 0;
        int end = 0;
        int ans = 0;
        
        while(end < n)
        {                       
           if(arr.get(end) == 0) k--;
           if(k<0)
           {
               while(arr.get(start) != 0) start++;
               start++;
               k++;
           } 
           else
           {
               int windowSize = end - start + 1 ;
               ans = Math.max(ans, windowSize);
           }
           end++;
        }
        
        return ans;
	}
}
