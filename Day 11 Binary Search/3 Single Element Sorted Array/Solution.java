import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int xor = 0 ;
        
        for (int num : arr) xor ^= num ;
        
        return xor ;
    }
}
