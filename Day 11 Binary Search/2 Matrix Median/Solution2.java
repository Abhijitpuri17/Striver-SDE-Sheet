import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int n = matrix.size();
        int m = matrix.get(0).size() ;
        
        int low = 1, high = (int)1e5 ;
        
        while (low <= high)
        {
            int mid = low + ((high - low)>>1) ;
            
            int cnt = numOfElementsLess(matrix, n, m, mid) ;
            
            if (cnt <= (n*m/2))
            {
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        
        return low ;
	}
    
    static int numOfElementsLess(ArrayList<ArrayList<Integer>> mat, int n, int m, int num)
    {
        int cnt = 0 ;
        for (int i = 0 ; i < n ; i++)
        {
            cnt += upperBound(mat.get(i), num) ;
        }
       
        return cnt ;
    }
    
    
    static int upperBound(ArrayList<Integer> list, int num)
    {
        int low = 0, high = list.size() ;
        
        while (low < high)
        {
            int mid =  low + ((high-low)>>1) ;
            
            if (list.get(mid) <= num) {
                low = mid + 1 ;
            } else high = mid ;
        }
        
        return low ;
    }
    
}
