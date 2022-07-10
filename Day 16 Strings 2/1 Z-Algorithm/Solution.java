// BruteForce

public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
        int ans = 0 ;
        for (int i = 0 ; i <= n - m; i++)
        {
            boolean isEqual = true ;
            for (int j = 0; j < m; j++)
            {
                if (p.charAt(j) != s.charAt(i+j))
                {
                    isEqual = false ;
                    break ;
                }
            }
            if (isEqual) ans++ ;
        }
        
        return ans ;
	}

}
