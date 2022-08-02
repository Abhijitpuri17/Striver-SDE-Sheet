import java.util.* ;
public class Solution {

    public static int minCharsforPalindrome(String str) 
    {
        StringBuilder sb = new StringBuilder(str) ;
        
        StringBuilder rev = new StringBuilder(str) ;
        rev.reverse() ;
        
        sb.append('$') ;
        sb.append(rev) ;
        
        int n = sb.length() ;
        
        int[] lps = new int[n] ;
        
        for(int i = 1; i < n; i++)
        {
            int x = lps[i-1] ;
            while(sb.charAt(x) != sb.charAt(i))
            {
                if(x == 0){
                    x-- ;
                    break ;
                }
                x = lps[x-1] ;
            }
            lps[i] = x + 1 ;
        }
        
        return str.length() - lps[n-1] ;
    }

    
    
}
