public class Solution 
{
	public static String reverseString(String s) 
	{
		StringBuilder sb = new StringBuilder("") ;
        
        StringBuilder curr = new StringBuilder("") ;
        
        for (int i = s.length()-1; i >= 0; i--)
        {
            if (s.charAt(i) == ' '){
                if (curr.length() != 0) {
                    curr.reverse() ;
                    if (sb.length() != 0)
                    sb.append(" ") ;
                    sb.append(curr.toString()) ; 
                    curr = new StringBuilder("") ;
                }
            } else {
                curr.append(s.charAt(i)) ;
            }
        }
        
        if (curr.length() > 0) {
            curr.reverse() ;
            if (sb.length() != 0)
                sb.append(" ") ;
            sb.append(curr.toString()) ;
        }
        
       return sb.toString() ;
	}
}
