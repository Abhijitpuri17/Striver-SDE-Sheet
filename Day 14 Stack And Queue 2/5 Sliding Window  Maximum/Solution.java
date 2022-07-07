
import java.util.* ;;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
        int n = nums.size() ;
        ArrayDeque<Integer> adq = new ArrayDeque<>() ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for (int i =  0 ; i < n; i++)
        {
            // remove elements which are not in current window
            while (!adq.isEmpty() && i - adq.peekFirst() >= k) 
                adq.pollFirst() ;
            
            // remove all the elements from last which are smaller than curr
            while (!adq.isEmpty() && nums.get(adq.peekLast()) <= nums.get(i))
                adq.pollLast() ;
            
            adq.offerLast(i);

            if (i >= k-1) 
            {
                ans.add(nums.get(adq.peekFirst())) ;
            }    
        }
        
        return ans ;
	}
}
