public class Solution 
{
    public static boolean findPattern(String p, String s) 
    {
        for (int i = 0 ; i <= s.length() - p.length(); i++)
        {
            boolean flag = true ;
            
            if  (s.charAt(i) != p.charAt(0) ||s.charAt(i+p.length()-1) != p.charAt(p.length()-1))
            {
                continue ;
            }
            
            for (int j = 0; j < p.length(); j++)
            {
                if (s.charAt(i+j) != p.charAt(j))
                {
                    flag = false ;
                    break ;
                }
            }
            if (flag)
                return true ;
        }
        
        return false ;
    }
}
