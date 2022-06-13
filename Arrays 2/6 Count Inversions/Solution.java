import java.util.* ;
import java.io.*; 
public class Solution {
  
    public static long getInversions(long arr[], int n) {
        long ans = mergeSort(arr, 0, n-1) ;
        return ans ;
    }
    
    static long mergeSort(long[] arr, int start, int end)
    {
        if (start >= end) return 0;
        
        int mid = start + ((end-start)>>1) ;
        
        long a = mergeSort(arr, start, mid) ;
        long b = mergeSort(arr, mid+1, end) ;
        long c = merge(arr, start, mid, end) ;
        
        return a + b + c ;
    }
    
    static long merge(long[] arr, int start, int mid, int end)
    {
        int i = start, j = mid + 1, k = 0 ;
        
        long[] temp = new long[end - start + 1] ;
    
        long inv = 0 ;
        
        while (i <= mid && j <= end)
        {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++] ;
            } else {
                inv += (mid - i + 1) ;
                temp[k++] = arr[j++] ;
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++] ;
        }
        
        while (j <= end) {
            temp[k++] = arr[j++] ;
        }
        
        for (i = 0; i < temp.length; i++)
        {
            arr[i+start] = temp[i] ;
        }
        
        return inv ;
    }
}
