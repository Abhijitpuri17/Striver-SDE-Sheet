import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int[][] matrix)
    {
        boolean isFirstColumnZero = false ;
       
        int rows = matrix.length ;
        int cols = matrix[0].length ;
       
        for (int i = 0 ; i < rows ; i++)
        {
            if (matrix[i][0] == 0) isFirstColumnZero = true ;
            for (int j = 1; j < cols; j++)
            {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0 ;
                    matrix[0][j] = 0 ;
                }
            }
        }
        
        for (int i = rows-1; i >= 0; i--)
        {
            for (int j = 1; j < cols; j++)
            {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0 ;
                }
            }
            
            if (isFirstColumnZero) matrix[i][0] = 0 ;
        }
        
        
        
    }
}
