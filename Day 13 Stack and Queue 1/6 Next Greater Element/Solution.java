import java.util.* ;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		
        Stack<Integer> st = new Stack<>() ;
        
        for(int i = n-1; i >= 0 ; i--)
        {
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop() ;
            
            int x = st.isEmpty()? -1 : st.peek() ;
            
            st.push(arr[i]) ;
            
            arr[i] = x ; 
        }
        
        return arr ;
	}

}
