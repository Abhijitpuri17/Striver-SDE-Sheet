import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		  PriorityQueue<Triplet> pq = new PriorityQueue<>((p1, p2)->{
            return p1.x - p2.x ;
        }) ;
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for (int i = 0 ; i < k; i++)
        {
           pq.add(new Triplet(kArrays.get(i).get(0), i, 0)) ;
        }
        
        while (!pq.isEmpty())
        {
            Triplet p = pq.poll() ;
            
            ans.add(p.x) ;
        
            if (kArrays.get(p.y).size() > p.z+1){
                pq.add(new Triplet(kArrays.get(p.y).get(p.z+1), p.y, p.z+1)) ;
            }    
        }
        
        return ans ;
	}

}

   class Triplet
   {
        int x, y, z;
        Triplet(int x, int y, int z)
        {
            this.x = x ;
            this.y = y ;
            this.z = z ;
        }
    }
