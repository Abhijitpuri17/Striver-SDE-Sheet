public class Solution {
	public static String graphColoring(int[][] mat, int m) 
   {
       
        int n = mat.length ;
        
        int[] colors = new int[n] ;
        
        if (helper(mat, n, colors, m, 0)) return "YES" ;
        return "NO" ;
	 }
   
 
    static boolean helper(int[][] mat, int n ,int[] colors, int m, int ind)
    {
        if (ind == n) return true ;
       
        for (int i = 1 ; i <= m; i++)
        {
            if (canColor(mat, n, ind, colors, i))
            {
                colors[ind] = i ;
                boolean sub = helper(mat, n, colors, m, ind+1) ;
                if (sub) return true ;
                colors[ind] = 0 ;
            } 
        }
        return false ;
    }
    
   static boolean canColor(int[][] mat, int n, int ind, int[] colors, int c)
    {
        for (int i = 0 ; i < n ; i++)
        {
            if (ind != i && mat[ind][i] == 1 && colors[i] == c) return false ;
        }
        return true ;
    }
  
  
  
   
}
