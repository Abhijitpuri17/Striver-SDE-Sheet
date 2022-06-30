import java.util.* ;

public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>() ;
        
        char[] arr = s.toCharArray() ;
        helper(ans, arr, 0) ;
        
        return ans ;
    }
    
    static void helper(List<String> ans, char[] arr, int ind)
    {
        if (ind == arr.length)
        {
            ans.add(new String(arr)) ;
            return ;
        }
        
        for (int i = ind; i < arr.length; i++)
        {
            swap(arr, ind, i) ;
            helper(ans, arr, ind+1) ;
            swap(arr, ind, i) ;
        }

    }
    
    static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    
}
