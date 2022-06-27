import java.util.* ;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        
        Arrays.sort(arr) ;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        ArrayList<Integer> curr = new ArrayList<>() ;
        
        helper(arr, 0, ans, curr) ;
        
        return ans ;
    }

    static void helper(int[] nums, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr)
    {
        ans.add(new ArrayList<>(curr)) ;
        
        for (int i = index; i < nums.length; i++)
        {
            if (i > index && nums[i] == nums[i-1]) continue ;
            
            curr.add(nums[i]) ;
            helper(nums, i+1, ans, curr) ;
            curr.remove(curr.size()-1) ;
        }
    }
}
