import java.util.* ;
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
 
        ArrayList<Integer> ans = new ArrayList<>() ;
 
        helper(num, num.length-1, 0, ans) ;
        
        Collections.sort(ans) ;
        
        
        return ans ;
        
    }
    
    public static void helper(int[] num, int index, int sum, ArrayList<Integer> ans)
    {
        if (index < 0) {
            ans.add(sum) ;
            return ;
        }

        // dont take current element
        helper(num, index-1, sum, ans) ;
        //take current element
        sum += num[index] ;
        helper(num, index-1, sum, ans) ;
    }
}
