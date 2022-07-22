public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        if (image[x][y] != newColor)
            dfs(image, x, y, newColor, image[x][y]) ;
        
        return image ;
    }
    
     static void dfs(int[][] mat, int r, int c, int color, int before)
    {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] != before)
            return ;
        
        mat[r][c] = color ;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} ;
        
        for (int[] dir: dirs)
        {
            dfs(mat, r + dir[0], c +  dir[1], color, before) ;
        }
    }
    
    
}

