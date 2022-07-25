
public class Solution
{

	public static int lcs(String s, String t) 
    {
		int len1 = s.length(), len2 = t.length() ;
        
        int[] prev = new int[len2+1] ;
        
        for (int i = 1; i <= len1; i++)
        {
            int[] curr  = new int[len2 + 1] ;
            for (int j = 1; j <= len2; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    curr[j] = prev[j-1] + 1 ;
                }
                else
                {
                    curr[j] = Math.max(prev[j], curr[j-1]) ;
                }
            }
            prev = curr ;
        }
        
        return prev[len2] ;
    }

}
