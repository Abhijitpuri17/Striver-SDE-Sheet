import java.util.* ;
public class Solution {
    public static int romanToInt(String s) {
      
        HashMap<Character, Integer> map = new HashMap<>() ;
        map.put('I', 1) ;
        map.put('V', 5) ;
        map.put('X', 10) ;
        map.put('L', 50) ;
        map.put('C', 100) ;
        map.put('D', 500) ;
        map.put('M', 1000) ;
        
        int n = s.length() ;
        int ans = map.get(s.charAt(n-1)) ;
        
        for (int i = n-2; i >= 0; i--)
        {
            int a = map.get(s.charAt(i)) ;
            int b = map.get(s.charAt(i+1)) ;
            
            if (a < b) 
                ans -= a ;
            else 
                ans += a ;
        }
        
        return ans ;
    }
}
