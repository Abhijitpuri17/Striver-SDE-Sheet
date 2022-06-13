import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        HashSet<Integer> hs = new HashSet<>() ;
        
        for (int num : arr){
            if (hs.contains(num)) return num ;
            hs.add(num) ;
        }
        
        return -1 ;
    }
}
