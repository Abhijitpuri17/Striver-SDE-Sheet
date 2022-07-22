import java.util.*;
public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) 
  {
		return quick_select(arr, 0, size-1, size-K) ;
	}
    
    
    static int quick_select(ArrayList<Integer> arr, int s, int e, int k)
    {
        
        int pivot_ind = partition(arr, s, e) ;
        if (pivot_ind == k) return arr.get(k)  ;
        
        if (pivot_ind > k) 
            return quick_select(arr, s, pivot_ind-1, k) ;
        
        return quick_select(arr, pivot_ind+1, e, k) ;
    }
    
    static int partition(ArrayList<Integer> arr, int s, int e)
    {
        
        int pivot = arr.get(s) ;
        int i = s + 1 , j = e ;
        
        do
        {
            while (i < e && arr.get(i) <= pivot) i++ ;
            
            while (j > s && arr.get(j) >= pivot) j-- ;
            
            if (i < j)
                swap(arr, i , j) ;    
        } while (i < j);
        
        swap(arr, s, j);
        
        return j ;
        
    }
    
    
    public static void swap(ArrayList<Integer> arr , int i , int j)
    {
         if (i == j) return ;
                     
        int temp = arr.get(i) ;
        arr.set(i, arr.get(j)) ;
        arr.set(j, temp) ; 
    }
  
}
