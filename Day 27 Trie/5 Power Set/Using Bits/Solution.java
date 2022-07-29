import java.util.* ;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr)
    {
 
        int n = arr.size() ;
  
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        for (int i = 0; i < (1 << n); i++)
        {
            ArrayList<Integer> curr = new ArrayList<>() ;
            
            for (int j = 0; j < n; j++)
            {
                if ((i & (1 << j)) != 0)
                   curr.add(arr.get(j)) ;
            }
            
            ans.add(curr) ;
        }
        
        return ans ;
    }
    
    
}

