import java.util.* ;
public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		
        ArrayList<Integer> combinations = new ArrayList<>() ;
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        
        for (int x : a)
        {
            for (int y : b)
            {
                int combn = x + y ;
                if (pq.size() < k)
                    pq.add(combn) ;
                else
                {
                    if (pq.peek() < combn)
                    {
                        pq.poll() ;
                        pq.add(combn) ;
                    }
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        while (!pq.isEmpty())
            ans.add(pq.poll()) ;
        
        reverse(ans, 0, ans.size()-1) ;
        return ans ;
	}
    
    static void reverse(ArrayList<Integer> arr, int start, int end)
    {
        while (start < end)
        {
            int temp = arr.get(start) ;
            arr.set(start, arr.get(end)) ;
            arr.set(end, temp) ;
            start++ ;
            end-- ;
        }
    }
    
}
