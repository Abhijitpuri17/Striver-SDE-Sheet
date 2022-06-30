import java.util.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
	
        HashSet<String> dict = new HashSet<>() ;
        for (String word : dictionary) {
            dict.add(word) ;
        }
        
        ArrayList<String> ans = new ArrayList<>() ;
        StringBuilder curr = new StringBuilder("") ;
        
        helper(ans, curr, dict, 0, s, s.length()) ;
        
        return ans ;
        
	}
    
    static void helper(ArrayList<String> ans, StringBuilder curr, HashSet<String> dict, 
                      int ind, String s, int n)
    {
        
        if (ind == n)
        {
            ans.add(curr.toString()) ;
            return ;
        }
        
        for (int i = ind; i < n; i++)
        {
            if (dict.contains(s.substring(ind, i+1)))
            {
                curr.append(s.substring(ind, i+1)) ;
                curr.append(" ") ;
                helper(ans, curr, dict, i+1, s, n) ;
                curr.delete(curr.length() - (i+2-ind), curr.length()) ;
            }
        }
        
    }
    
    
}
