import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
        
		int prefixXor = 0 ;
        int arrLen = arr.size() ;
        int ans = 0 ;
        
        HashMap<Integer, Integer> freq = new HashMap<>() ;
        
        for (int i = 0 ; i < arrLen; i++)
        {
            prefixXor ^= arr.get(i) ;
            
            if (prefixXor == x) ans++ ;
       
            int rem = prefixXor ^ x ;
            
            if (freq.containsKey(rem)) {
                ans += freq.get(rem) ;
            }
            
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1) ;
        }
        
        return ans ;
        
        
	}
}
