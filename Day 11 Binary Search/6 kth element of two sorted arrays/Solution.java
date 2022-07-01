public class Solution 
{
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k)     
    {

        int low = 0, high = (int)1e5 ;
        
        while (low <= high)
        {
            int mid = low + ((high-low)>>1) ;
            
            int numOfLess = upperBound(row1, mid) + upperBound(row2, mid) ;
           
            if (numOfLess <= k-1) 
                low = mid + 1 ;
            else
                high = mid - 1 ;
        }
        
        return low ;
    }
    
    
    public static int upperBound(int[] arr, int key)
    {
        int low = 0, high = arr.length ;
        
        while (low < high)
        {
            int mid  = low + ((high - low)>>1) ;
            
            if (arr[mid] <= key) 
                low = mid + 1 ;
            else high = mid ;
        }
        
        return high ;
    }
    
}
