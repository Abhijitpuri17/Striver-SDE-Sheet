import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) 
  {
        int n = heights.size() ;
        int[] left = new int[n] ;
        int[] right = new int[n] ;
        
        Stack<Integer> st = new Stack<>() ;
        
        for (int i = 0 ; i < n ; i++)
        {
            while (!st.isEmpty() && heights.get(i) <= heights.get(st.peek())) 
                st.pop() ;
            
            if (st.isEmpty()) 
                left[i] = -1 ;            
            else
                left[i] = st.peek() ;
            
            st.push(i);
        }
        
        st.clear() ;
        
        for (int i = n-1; i >= 0 ;  i--)
        {
            while (!st.isEmpty() && heights.get(i) <= heights.get(st.peek()))
                st.pop() ;
            
            if (st.isEmpty()) 
                right[i] = n ;
            else
                right[i] = st.peek() ;
            
            st.push(i) ;
        }
        
        int ans = 0 ;
      
        for  (int  i  = 0 ; i <  n ; i++)
        {
            ans = Math.max(ans, heights.get(i) * (right[i] - left[i] - 1)) ;
        }
      
        return ans ;
  }
}
