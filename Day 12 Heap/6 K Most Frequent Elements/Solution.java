import java.util.* ;
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
	
        HashMap<Integer, Integer> map = new HashMap<>() ;
        
        for (int num : arr)
        {
            map.put(num, map.getOrDefault(num, 0)+1) ;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->{
            return p2.y - p1.y ;
        }) ;
        
        for (int key: map.keySet())
        {
            pq.add(new Pair(key, map.get(key))) ;
        }
        
        int[] ans = new int[k] ;
        int i = 0 ;
        
        while (i < k && !pq.isEmpty())
        {
            ans[i++] = pq.poll().x ;
        }
        
        Arrays.sort(ans) ;
                
        return ans ;
	} 
}

class Pair{
    int x, y ;
    Pair(int x, int y)
    {
        this.x = x ;
        this.y = y ;
    }
}
