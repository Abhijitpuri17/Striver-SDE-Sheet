import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        
        int xor = 0 ;
        
        for (int i = 1; i <= n ; i++) xor ^= i ;
        
        for (int num : arr) xor ^= num ;
        
        int mask = xor & -xor ;
        int temp = xor ;
        
        for (int num: arr) {
            if ((num & mask) == 0) xor ^= num ;
        }
        
        for (int i = 1; i <= n ; i++) {
            if ((i & mask) == 0)
            xor ^= i ;
        }
        
        for (int num: arr){
            if (num == xor) {
                return new int[]{temp^xor, xor} ;
            }
            
            if (num == (temp^xor)){
                return new int[]{xor, temp^xor} ;
            }
        }
        
        return new int[]{xor, temp ^ xor} ;   
    }
}
