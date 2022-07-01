import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) 
    {
         
        int[] arr = new int[n] ;
        
        for (int i = 0; i < n ; i++) arr[i] = i+1 ;
        
        for (int i = 0; i < k-1; i++)
        {
            nextPerm(arr, n) ;           
        }
        
        StringBuilder ans = new StringBuilder("") ;
        
        for (int i = 0 ; i < n; i++)
        {
            ans.append(Integer.toString(arr[i])) ;
        }
        

        return ans.toString() ;
    }
  
    public static void nextPerm(int[] arr, int n)
    {
        
        int i = n-2 ;
        
        while (i >= 0 && arr[i] > arr[i+1]) i-- ;
        
        if (i < 0) {
            reverse(arr, 0, n-1) ;
            return ;
        }
        
        int j = n-1 ;
        
        while (j > i && arr[j] <= arr[i]) j-- ;
        
        swap(arr, i, j) ;
        
        reverse(arr, i+1, n-1) ;
        
    }
    
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    
    
    public static void reverse(int[] arr, int start, int end)
    {
        while (start < end)
        {
            swap(arr, start, end) ;
            start++;
            end-- ;
        }
    }
    
}
