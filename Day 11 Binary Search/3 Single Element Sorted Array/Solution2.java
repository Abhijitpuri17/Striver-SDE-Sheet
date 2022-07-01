import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int n = arr.size() ;
        int low = 0, high = n - 1 ;
        
        while (low <= high)
        {
            int mid =  (low + high)/2 ;
                        
            if (mid < n - 1 && arr.get(mid) - arr.get(mid+1) == 0)
            {
                if (mid%2 == 0)
                {
                    low = mid + 1 ;
                } 
                else
                {
                    high = mid - 1 ;
                }
            }
            else if (mid > 0 && arr.get(mid) - arr.get(mid - 1) == 0)
            {
                if (mid%2 == 0)
                {
                    high = mid - 1 ;
                }
                else 
                {
                    low = mid + 1 ;
                }
            }
            else
            {
                return arr.get(mid) ;
            }
        }
        
        return -1 ;
 
    }
}
