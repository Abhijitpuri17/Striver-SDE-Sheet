import java.util.* ;
public class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>() ;
        List<String> curr = new ArrayList<>() ;
        
        helper(ans, curr, s, 0) ;
        
        return ans ;
        
    }
    
    static void helper(List<List<String>> ans, List<String> curr, String s, int start)
    {
        if (start == s.length())
        {
            ans.add(new ArrayList<>(curr)) ;
            return ;
        }
        
        for (int i = start; i < s.length(); i++)
        {
            
            if (isPalindrome(s, start, i))
            {
                curr.add(s.substring(start, i+1)) ;
                helper(ans, curr, s, i+1) ;
                curr.remove(curr.size()-1) ;
            }
        }

    }
    
    static boolean isPalindrome(String s, int start, int end)
    {
        
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end)) return false ;
            start++ ; end-- ;
        }
        
        return true ;
    }
}
