import java.util.* ;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        
        ArrayList<Integer> curr = new ArrayList<>() ;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        helper(ans, curr, 0, arr, n, k) ;
        
        return ans ;
        
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int index, ArrayList<Integer> arr, int n, int target)
    {
        if (index == n)
        {
            int sum = 0 ;
            for (int num : curr) sum += num ;
            
            if (sum == target)
            {
                ans.add(new ArrayList<>(curr)) ;
            }
            return ;
        }
        
        curr.add(arr.get(index)) ;
        
        helper(ans, curr, index+1, arr, n, target) ;
        
        curr.remove(curr.size()-1) ;

        helper(ans, curr, index+1, arr, n, target) ;
        
    }
      
}
