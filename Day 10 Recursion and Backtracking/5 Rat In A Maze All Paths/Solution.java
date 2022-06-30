import java.util.* ;
public class Solution {
  
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
      
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n] ;
        helper(ans, maze, n, 0, 0, visited) ;
        
        return ans ;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, int[][] maze, int n, int row, int col, boolean[][] visited)
    {
        if (row >= n || col >= n || row < 0 || col < 0 
            || visited[row][col] || maze[row][col] == 0) return ;
        
        visited[row][col] = true ;
        
        if (row == n-1 && col == n-1)
        {
            if (maze[row][col] == 0) return ;
            ArrayList<Integer> curr = new ArrayList<>() ;
            
            for (int i = 0 ; i < n ; i++)
            {
                for (int j = 0 ; j < n ; j++)
                {
                    if (maze[i][j] == 1 && visited[i][j])
                    {
                        curr.add(1) ;
                    } else curr.add(0) ;
                }
            }
            ans.add(new ArrayList<>(curr)) ;
            visited[row][col] = false ;
            return ;
        }
        
        helper(ans, maze, n, row+1, col, visited) ;
        helper(ans, maze, n, row-1, col, visited) ;
        helper(ans, maze, n, row, col+1, visited) ;
        helper(ans, maze, n, row, col-1, visited) ;
        
        visited[row][col] = false ;
  
    }
}
