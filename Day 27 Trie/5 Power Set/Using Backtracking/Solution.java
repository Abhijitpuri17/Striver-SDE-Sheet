import java.util.* ;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr)
    {
        int n = arr.size() ;
  
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        ArrayList<Integer> curr = new ArrayList<>() ;
        
        helper(ans, curr, arr, 0) ;
        
        return ans ;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, ArrayList<Integer> arr, int ind)
    {
        if (ind == arr.size())
        {
            ans.add(new ArrayList<>(curr)) ;
            return ;
        }
        
        // not included
        helper(ans, curr, arr, ind+1) ;
        
        // included
        curr.add(arr.get(ind)) ;
        helper(ans, curr, arr, ind+1) ;
        curr.remove(curr.size()-1) ;
    }
}

