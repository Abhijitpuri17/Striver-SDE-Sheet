public class Solution {	
	public static String longestPalinSubstring(String str) 
    {
       int maxLen = 0, start = 0, currlen = 0 ;
    
		    for (int i = 0 ; i < str.length(); i++)
        {
            int len1 = getLength(str, i, i) ;
            int len2 = getLength(str, i, i+1);
            
            currlen = Math.max(len1, len2) ;
            
            if (maxLen < currlen)
            {
                maxLen = currlen ;
                start = i - (currlen-1)/2 ;
            }
        }
    
      return str.substring(start, start+maxLen) ;
	}
    
    static int getLength(String str, int i, int j)
    {
        if (j >= str.length()) return 0 ;
        int len = 1 ;
        if (i != j)
        {
            if (str.charAt(i) != str.charAt(j)) return 0 ;
            len++;
        }
        
        i--; j++ ;
        
        while (i >= 0 && j <  str.length())
        {
            if (str.charAt(i) != str.charAt(j))
                break ;
            
            len += 2 ;
            i-- ;
            j++ ;
        }

        return len ;
    }
    
    
}
