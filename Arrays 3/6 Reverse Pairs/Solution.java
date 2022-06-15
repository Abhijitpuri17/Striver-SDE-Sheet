import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    
    static int mergeSort(ArrayList<Integer> nums, int s, int e)
    {
        if (e == s) return 0;
        
        int mid = (s+e)/2 ;
        int lrp = mergeSort(nums, s, mid) ;
        int rrp = mergeSort(nums, mid+1, e) ;
        int irp =  merge(nums, s, mid, e) ;
        
       return lrp + rrp + irp ;
    }
    
    static int merge(ArrayList<Integer> nums, int s, int mid, int e)
    {
        int cnt = 0 ;
        
        int i = s , j = mid+1, k = 0 ;
        
        while (i <= mid)
        {
            while (j <= e && nums.get(i) > 2*(long)nums.get(j)) j++ ;
            
            cnt += j - (mid+1) ;
            
            i++ ;
        }
        
         i = s ; j = mid+1 ;
        
        ArrayList<Integer> temp = new ArrayList<>() ;
        
        while (i <= mid && j <= e)
        {
            if (nums.get(i) < nums.get(j)) temp.add(nums.get(i++)) ;
            else temp.add(nums.get(j++)) ;
        }
        
        while (i <= mid) temp.add(nums.get(i++)) ;
        while (j <= e) temp.add(nums.get(j++)) ;
        
        for (int m = 0 ; m < e-s+1 ; m++) {
            nums.set(m+s, temp.get(m)) ;
        }
        
        return cnt ;

    }
    
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        return mergeSort(arr, 0, arr.size()-1) ;
    }
}
