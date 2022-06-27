import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        
        int k = m + n - 1 ;
        m-- ;
        n-- ;
        
        while (m >= 0 && n >= 0) {
            if (arr1[m] > arr2[n]) arr1[k--] = arr1[m--] ;
            else arr1[k--] = arr2[n--] ;
        }
        
        while (m >= 0) arr1[k--] = arr1[m--] ;
        
        while (n >= 0) arr1[k--] = arr2[n--] ;
        
        
        return arr1 ;   
    }  
}
