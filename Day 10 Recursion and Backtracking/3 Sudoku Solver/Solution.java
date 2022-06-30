public class Solution {

	public static boolean isItSudoku(int matrix[][]) {
        return helper(matrix, 0, 0) ;
	}
    
    static boolean helper(int[][] board, int row, int col)
    {
        if (row == 9) return true ;
        
        if (col == 9) {
            return helper(board, row+1, 0) ;
        }
        
        if (board[row][col] != 0) return helper(board, row, col+1) ;
        
        for (int num = 1; num <= 9 ; num++)
        {
            board[row][col] = num ;
            if (isSafe(board, row, col)){
                boolean sub = helper(board, row, col+1) ;
                if (sub) return true ;
            }
            board[row][col] = 0 ;
        }
        
        return false ;
    }
    
    static boolean isSafe(int[][] board, int row, int col)
    {
        for (int i = 0 ; i < 9; i++)
        {
            if (i != row && board[i][col] == board[row][col]) return false ;
            if (i != col && board[row][i] == board[row][col]) return false ;
        }
        
        int r = row / 3 * 3 ;
        int c = col / 3 * 3 ;
        
        for (int i = r; i < r + 3 ; i++)
        {
            for (int j = c ; j < c + 3 ; j++)
            {
                if (r == row && c == col) continue ;
                if (board[r][c] == board[row][col]) return false ;
            }
        }
        
        return true ;
    }
  
}
