import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int numRows) 
    {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>() ;
        
        ArrayList<Long> l1 = new ArrayList<>() ;
        l1.add(1L) ;
        ans.add(l1) ;
        
        for (int i = 1 ; i < numRows; i++)
        {
            l1 = new ArrayList<>() ;
            l1.add(1L) ;
            
            int j = 0 ;
            while (j < i-1)
            {
                l1.add(ans.get(i-1).get(j) + ans.get(i-1).get(j+1)) ;
                j++ ;
            }
            l1.add(1L) ;
            ans.add(l1) ;
        }
        
        return ans ;
             
    }
}
