import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        
        int i = 0, j = 0, k = n-1, l = m-1 ;
        
        for (int cnt = 0; cnt < Math.min(n/2, m/2); cnt++)
        {
            int temp = mat.get(i).get(j) ;

            for (int x = i; x < k; x++)
            {
                mat.get(x).set(j, mat.get(x+1).get(j)) ;
            }

            for (int x = j; x < l; x++)
            {
                mat.get(k).set(x, mat.get(k).get(x+1)) ;
            }

            for (int x = k; x > i; x--)
            {
                mat.get(x).set(l, mat.get(x-1).get(l)) ;
            }

            for (int x = l; x > j+1 ; x--)
            {
                mat.get(i).set(x, mat.get(i).get(x-1)) ;
            }
            
            mat.get(i).set(j+1, temp) ;
            
            i++; j++ ; k--; l-- ;

        }
        
    }
}
