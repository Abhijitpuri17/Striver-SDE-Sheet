import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int[][] matrix)
    {
        
        int m = matrix.length ;
        int n = matrix[0].length ;
        Set<Integer> rowSet = new HashSet<>() ;
        Set<Integer> colSet = new HashSet<>() ;
        
        for (int i = 0 ; i < m ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                if (matrix[i][j] == 0) {
                    rowSet.add(i) ;
                    colSet.add(j) ;
                }
            }
        }
        
        for (int x : colSet)
        {
            for (int i = 0 ; i < m ; i++)
            {
                matrix[i][x] = 0 ;
            }
        }
        
        for (int x : rowSet)
        {
            for (int i = 0 ; i < n ; i++)
            {
                matrix[x][i] = 0 ;
            }
        }
        
    }
}
