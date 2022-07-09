
public class Solution {
	public static String longestCommonPrefix(String[] strs, int n) {
		StringBuilder ans = new StringBuilder("") ;
        
        n = strs[0].length() ;
        
        boolean flag = false ;
        
        for (int i = 0 ; i < n; i++)
        {
           char ch = strs[0].charAt(i) ;
           for (String str: strs)
           {
               if (str.length() - 1 < i || ch != str.charAt(i)){
                   flag = true ;
                   break ;
               }
           } 
           if (flag) break ;
           
           ans.append(ch) ;
        }
        
        return ans.toString() ;
	}

}
