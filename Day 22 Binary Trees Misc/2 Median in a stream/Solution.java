import java.util.* ;
public class Solution 
{
    public static int[] findMedian(int[] arr, int n) 
    {
        int[] medians = new int[n] ;
        
        PriorityQueue<Integer> small = new PriorityQueue<>((p1,p2)->{
            return p2 - p1 ;
        }) ;
        
        PriorityQueue<Integer> large = new PriorityQueue<>() ;
      
        for (int i = 0 ; i <  n; i++)
        {
            if (small.size() == large.size())
            {
                large.add(arr[i]) ;
                small.add(large.poll()) ;
            }
            else
            {
                small.add(arr[i]) ;
                large.add(small.poll()) ;
            }
            
            int m = small.peek() ;
            if  (small.size() == large.size())
            {
                m = (m+large.peek()) / 2 ;
            }
            
            medians[i] = m ;
        }
        
        return medians ;
    }
}
