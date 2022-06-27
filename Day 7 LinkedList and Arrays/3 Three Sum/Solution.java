import java.util.* ;
import java.io.*; 
public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

        sort(arr) ;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        for (int i = 0 ; i < n - 2; i++)
        {
            int target = K - arr[i] ;
            
            int start = i + 1, end = n - 1 ;
            
            while (start < end)
            {
                if (arr[start] + arr[end] == target)
                {
                    ArrayList<Integer> al = new ArrayList<>() ;
                    al.add(arr[i]) ;
                    al.add(arr[start]) ;
                    al.add(arr[end]) ;
                    ans.add(al) ;
                    
                    int l = arr[start], h = arr[end] ;
                    while (start < end && arr[start] == l) start++ ;
                    while (start < end && arr[end] == h) end-- ;
                    
                } else if (arr[start] + arr[end] < target){
                    start++ ;
                } else end-- ;
            }
            
            while(i < n-1 && arr[i] == arr[i+1]) i++ ;
            
            
        }
        
        return ans ;
    }
    
    static void sort(int[] arr)
    {
        ArrayList<Integer> al = new ArrayList<>() ;
        
        for (int num : arr) al.add(num) ;
        
        Collections.sort(al) ;
        
        int i = 0 ;
        
        for (int num : al) arr[i++] = num ;
        
    }
    
}
