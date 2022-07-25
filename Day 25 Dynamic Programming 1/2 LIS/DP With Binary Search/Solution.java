import java.util.* ;
public class Solution 
{

	public static int longestIncreasingSubsequence(int arr[]) 
    {
        int n = arr.length ;
		
        ArrayList<Integer> list = new ArrayList<>() ;
      
        for (int i = 0 ; i < n; i++)
        {
            int lb = lowerBound(list, arr[i]) ;
            if (lb == list.size())
                list.add(arr[i]) ;
            else
                list.set(lb, arr[i]) ;
        }
        
        return list.size() ;
	}
    
    static int lowerBound(ArrayList<Integer> list, int key)
    {
        int start = 0, end = list.size() ;
        
        while (start < end)
        {
            int mid = start + ((end - start) >> 1) ;
            
            if (list.get(mid) >= key)
                end = mid ;
            else
                start = mid + 1 ;
        }
        
        return start ;
    }
    

}
