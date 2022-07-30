import java.util.* ;
public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) 
    {
        HashMap<String, Boolean> dp = new HashMap<>() ;
        HashSet<String> set = new HashSet<>() ;
        
        for (String word: arr)
            set.add(word) ;
       
        return helper(target, set, dp) ;
    }
    
    static boolean helper(String a, HashSet<String> set, HashMap<String, Boolean> dp)
    {
        if (a.length() == 0)
            return true ;
        
        if (dp.containsKey(a))
            return dp.get(a) ;
        
        for (int i = 1 ; i <= a.length(); i++)
        {
            if (set.contains(a.substring(0, i)))
            {
                if (helper(a.substring(i), set, dp)){
                    dp.put(a, true) ;
                    return true;
                }
            }
        }
        dp.put(a, false) ;
        return false ;
    }
    
}
