import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> countDistinct(ArrayList<Integer> arr, int n, int k) 
    {
        HashMap<Integer, Integer> freq = new HashMap<>() ;
        
        for (int i = 0 ; i < k ; i++)
        {
            freq.put(arr.get(i), freq.getOrDefault(arr.get(i), 0)+1) ;
        }
        
        int start = 0 ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        ans.add(freq.size()) ;
        
        for (int i = k; i < n; i++)
        {
            freq.put(arr.get(i), freq.getOrDefault(arr.get(i), 0)+1) ;
            freq.put(arr.get(start), freq.getOrDefault(arr.get(start), 0)-1) ;
            if (freq.get(arr.get(start)) <= 0){
                freq.remove(arr.get(start)) ;
            }
            
            ans.add(freq.size()) ;
            
            start++ ;
        }
        
       return  ans ; 
    }
}
