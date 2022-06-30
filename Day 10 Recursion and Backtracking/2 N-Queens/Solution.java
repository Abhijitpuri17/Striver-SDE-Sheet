import java.util.* ;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        ArrayList<Integer> board = new ArrayList<>() ;
        for (int i = 0 ; i < n*n ; i++) board.add(0) ;
        
        helper(ans, board, 0, n) ;
        
        return ans ;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> board,
                      int row, int n)
    {
        if (row == n)
        {
            ans.add(new ArrayList<>(board)) ;
            return ;
        }
        
        for (int col = 0; col < n; col++)
        {
            if (isSafe(board, n, row, col)){
                int pos = row * n + col ;
                board.set(pos, 1) ;
                helper(ans, board, row+1, n) ;
                board.set(pos, 0) ;
            }
        }
         
    }
    
    static boolean isSafe(ArrayList<Integer> board, int n, int row, int col)
    {
        for (int r = 0; r < n; r++)
        {
            int pos = r * n + col ;
            if (board.get(pos) == 1) return false ;
        }
        
        for (int c = 0; c < n; c++)
        {
            int pos = row * n + c ;
            if (board.get(pos) == 1) return false ;
        }
        
        int r = row - 1, c = col - 1 ;
        while (r >= 0 && c >= 0)
        {
            int pos = r * n + c ;
            if (board.get(pos) == 1) return false ;
            r-- ; c-- ;
        }
        
        r = row-1; c = col + 1 ;
        while (r >= 0 && c < n)
        {
            int pos = r * n + c ;
            if (board.get(pos) == 1) return false ;
            r-- ; c++ ;
        }
        
        return true ;
    }    
}
