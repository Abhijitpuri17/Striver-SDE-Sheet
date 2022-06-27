import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        
        for (int num : arr)
        {
            int index = Math.abs(num) ;
            
            if (arr.get(index) < 0) return index ;
            
            arr.set(index, arr.get(index)*-1) ;
            
        }
        
        return -1 ;
    }
}
