import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n-1; i >= 0 ; i--)
        {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) 
                stack.pop() ;
            
            int x;
            if (stack.isEmpty()) x = -1 ;
            else x = stack.peek() ;
            
            stack.push(arr.get(i)) ;
            
            arr.set(i, x);
        }
        
        return arr ;
    }
}
