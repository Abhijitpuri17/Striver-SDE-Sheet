import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) 
    {
        
        long[] fact = new long[10] ;
        
        long curr = 1 ;
        
        for (int i = 1; i <= 9; i++)
        {
            curr *= i;
            fact[i] = curr ;
        }
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        for (int i = 0; i < n; i++)
            list.add(i+1) ;
        
        StringBuilder sb = new StringBuilder("") ;
        
        int rem = n - 1 ;
        for (int i = 0; i < n && rem > 0; i++)
        {   
            int pos = (int)Math.ceil(k * 1.0/ fact[rem]) ;
            
            sb.append(list.get(pos-1)) ;
            
            list.remove(pos - 1) ;
            
            k -= (pos - 1) * (fact[rem]) ;
            
            rem-- ;
           
        }
        
        for (int x: list)
            sb.append(x) ;
        
        return sb.toString() ;
        
    }
  
  
}
