public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        int islands = 0 ;
        
        for (int i = 0 ; i < mat.length; i++)
        {
            for (int j = 0 ; j < mat[0].length; j++)
            {
                if (mat[i][j] == 1)
                {
                    islands++ ;
                    dfs(mat, i, j) ;
                }
            }
        }
        
        return islands ;
    }
    
    static void dfs(int[][] mat, int row, int col)
    {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length
            || mat[row][col] != 1)
            return ;
        
        mat[row][col] = -1 ;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1},
                        {-1, 1}, {-1, -1}} ;
        
        for (int[] dir: dirs)
        {
            int newRow = row + dir[0] ;
            int newCol = col + dir[1] ;
            dfs(mat, newRow, newCol) ;
        }
    }
    
    
}
