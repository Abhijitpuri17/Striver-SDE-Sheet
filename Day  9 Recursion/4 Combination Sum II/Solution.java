import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        ArrayList<Integer> curr = new ArrayList<>() ;
        
        Collections.sort(arr) ;
        helper(ans, curr, 0, arr, n, target) ;
        
        return ans ;
        
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr,
                      int index, ArrayList<Integer> arr, int n, int target)
    {
        
        int sum = 0 ;
        
        for (int num : curr) sum += num ;
        
        if (sum == target)
        {
            Collections.sort(curr) ;
            ans.add(new ArrayList<>(curr)) ;
        }
        
        
        for (int i = index; i < n;  i++)
        {
            if (i > index && arr.get(i) == arr.get(i-1)) continue ; 
            curr.add(arr.get(i)) ;
            helper(ans, curr, i+1, arr, n, target) ;
            curr.remove(curr.size()-1) ;
        } 
    }
    
}
