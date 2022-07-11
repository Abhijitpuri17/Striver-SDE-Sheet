public class Solution 
{
    public static int compareVersions(String v1, String v2) 
    {
         int i = 0, j = 0, k = 0, l = 0;
        
        while (i < v1.length() && j < v2.length())
        {
            while (k < v1.length() && v1.charAt(k) != '.') k++ ;

            while (i < k && v1.charAt(i) == '0') i++ ;

            while (l < v2.length() && v2.charAt(l) != '.') l++ ;

            while (j < l && v2.charAt(j) == '0') j++ ;
            
            if (k - i < l - j) return -1 ;
            else if (k-i > l - j) return 1 ;   
            
            while (i < k)
            {
                
                if (v1.charAt(i) != v2.charAt(j))
                {
                    int a = v1.charAt(i) - '0' ;
                    int b = v2.charAt(j) - '0' ;
                    
                    if (a < b) return -1 ;
                    else return 1 ;
                }
                
                i++ ; j++ ;
            }
            i = ++k; j = ++l ;        
       }
        
       for (; i < v1.length() ; i++) 
           if (v1.charAt(i) != '0' && v1.charAt(i) != '.')
               return 1 ; 
        
         for (; j < v2.length() ; j++) 
           if (v2.charAt(j) != '0' && v2.charAt(j) != '.')
               return -1 ; 
    
      return 0 ;
    }
}
