import java.util.* ;
public class Solution {

	public static int minTimeToRot(int[][] grid, int n, int m) {
		Queue<Pair> queue = new LinkedList<>() ;
        
        int tot = 0, rotten = 0 ;
        
        for (int i = 0 ; i <  n ; i++)
        {
            for (int j = 0 ; j < m ; j++)
            {
                if (grid[i][j] != 0) tot++ ;
                if (grid[i][j] == 2){
                    queue.add(new Pair(i, j)) ;
                }   
            }
        }
        
        int days = 0 ;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}} ;
        
        while (queue.isEmpty() == false)
        {
            
            int size = queue.size() ;
            rotten += size ;
            
            for (int i  = 0; i < size; i++)
            {
                Pair p = queue.poll() ;
                
                for (int[] dir: dirs)
                {
                    int nRow = p.row + dir[0] ;
                    int nCol = p.col + dir[1] ;
                    
                    if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= m || 
                        grid[nRow][nCol] != 1) continue ;
                    
                    grid[nRow][nCol] = 2 ;
                    
                    queue.add(new Pair(nRow, nCol)) ;
                }
            }
            if (queue.isEmpty() == false) days++  ;
        }
        
        
        if (rotten == tot) {
            return days ;
        }
        
        return -1 ;
	}

}

class Pair{
    int row, col ;
    
    Pair(int row, int col)
    {
        this.row = row;
        this.col = col ;
    }
    
}
