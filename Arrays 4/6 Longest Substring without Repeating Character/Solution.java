import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		    HashMap<Character, Integer> lastOccurance = new HashMap<>() ;
        
        int inputLen = input.length() ;
        int maxLen = 0 ;
        int start = 0 ;
        
        for (int i = 0; i < inputLen; i++)
        {
            char ch = input.charAt(i) ;
            
            if (lastOccurance.containsKey(ch))
            {
                start = Math.max(start, lastOccurance.get(ch) + 1) ;
            }
            
            lastOccurance.put(ch, i) ;
            
            int currLen = i - start + 1  ;
            maxLen = Math.max(currLen, maxLen) ;
        }
        
        return maxLen ;
	}
}
