public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
       if (n == 1)
           return "1" ;
        
        String prev = writeAsYouSpeak(n-1) ;
        
        StringBuilder sb = new StringBuilder("") ;
        
        int cnt = 0 ;
        char ch = prev.charAt(0) ;
        
        for (int i = 0 ; i < prev.length(); i++)
        {
            if (prev.charAt(i) == ch){
                cnt++ ;
            }else{
                sb.append(cnt) ;
                sb.append(ch) ;
                ch = prev.charAt(i) ;
                cnt = 1 ;
            }
        }
        
        sb.append(cnt) ;
        sb.append(ch) ;
        
        
        
        return sb.toString() ;
    }
}
