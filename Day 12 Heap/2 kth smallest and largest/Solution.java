import java.util.* ;

public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>() ;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p1, p2)->{
            return p2 - p1 ;
        }) ;
        for (int i = 0 ; i < k ; i++)
        {
            minHeap.add(arr.get(i)) ;
            maxHeap.add(arr.get(i)) ;
        }
        
        for (int i = k; i < n ; i++)
        {
            if (minHeap.peek() < arr.get(i))
            {
                minHeap.poll() ;
                minHeap.add(arr.get(i)) ;
            }
            
            if (maxHeap.peek() > arr.get(i))
            {
                maxHeap.poll() ;
                maxHeap.add(arr.get(i)) ;
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        ans.add(maxHeap.peek()) ;
        ans.add(minHeap.peek()) ;
        
        return ans ;
        
	}
}
