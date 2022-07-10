import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> stringMatch(String str, String pat) 
  {
    
		    ArrayList<Integer> ans = new ArrayList<>() ;
        
        int n = str.length() ;
        int m = pat.length() ;
        
        int hashS = 0 ;
        int hashP = 0 ;
        
        for (int i = 0 ; i < m; i++)
        {
            hashS += (str.charAt(i) - 'A' +  1) * Math.pow(5, i) ;
            hashP += (pat.charAt(i) - 'A' + 1) * Math.pow(5, i) ;
        }
        
        if (hashP == hashS)
        {
            if (areEqual(str, pat, 0))
            {
                ans.add(0) ;
            }
        }
        
        int start = 0, end = m ;
        
        while (end < n)
        {
            hashS -= (str.charAt(start) - 'A' + 1) ;
            hashS /= 5;
            hashS  += (str.charAt(end) - 'A'+1) * Math.pow(5, m-1) ;
                     
            if (hashS == hashP)
            {
                if (areEqual(str, pat, start+1))
                {
                    ans.add(start+1) ;
                }
            }
            start++ ; end++ ;
        }
        
        return ans ;
	}
    
   static boolean areEqual(String s1, String s2, int ind)
   {
       for (int i = 0; i < s2.length(); i++)
       {
           if (s1.charAt(ind+i) != s2.charAt(i))
             return false ;
       } 
       return true ;
   }
    
    
}
