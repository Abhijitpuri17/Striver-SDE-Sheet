public class Solution {
    public static int atoi(String str) {
        int ind = 0 ;
        int sign = 1 ;
        int num = 0 ;
        int n = str.length() ;
        
        if (str.charAt(ind) == '-') {
            sign = -1 ;
            ind++ ;
        } else if (str.charAt(ind) == '+'){
            ind++ ;
        }
        
        while (ind < n)
        {
            if (str.charAt(ind) >= '0' && str.charAt(ind) <= '9'){
                int a = str.charAt(ind) - '0' ;
                num = num * 10 + a ;
            }
            ind++ ;
        }
        
        return num * sign ;
        
    }
}
