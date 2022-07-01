public class Solution {
    public static int search(int arr[], int key) {
        
        int n = arr.length ;
        int low = 0, high = n - 1 ;
        
        while (low <= high)
        {
            int mid = low + ( (high - low )  >> 1) ;
            
            if (arr[mid] == key) return mid ;
            if (arr[mid] >= arr[low])
            {
                if (arr[mid] >= key && arr[low] <= key)
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
                if (arr[high] >= key && arr[mid] <= key)
                {
                    low = mid + 1 ;
                }
                else 
                {
                    high = mid - 1 ;
                }
            }
            
        }
        
       return -1 ;
        
    }
}
