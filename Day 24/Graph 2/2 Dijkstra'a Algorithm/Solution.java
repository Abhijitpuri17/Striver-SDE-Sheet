import java.util.* ;
public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source)
    {
		ArrayList<Pair>[] adj = new ArrayList[vertices] ;
        
        for (int i = 0 ; i <  vertices; i++)
        {
            adj[i] = new ArrayList<>() ;
        }
        
        for (ArrayList<Integer> edge: vec)
        {
            adj[edge.get(0)].add(new Pair(edge.get(1), edge.get(2))) ;
            adj[edge.get(1)].add(new Pair(edge.get(0), edge.get(2))) ;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return p1[1] - p2[1] ;
        }) ;
        
        ArrayList<Integer> distance = new  ArrayList<>() ;
        
        for (int i = 0 ; i < vertices; i++)
            distance.add(Integer.MAX_VALUE) ;
        
        distance.set(source, 0)  ;
        
        pq.add(new int[]{source, 0}) ;
        
        while (!pq.isEmpty())
        {
            int[] front = pq.poll() ;
            
            int node = front[0] ;
            int dist = front[1] ;
            
            for (Pair nbr: adj[node])
            {
                if (dist + nbr.weight < distance.get(nbr.node))
                {
                    distance.set(nbr.node, dist + nbr.weight) ;
                    pq.add(new int[]{nbr.node, distance.get(nbr.node)}) ;
                }
            }
       
        }
        
        return distance ;
        
	}
}

class Pair{
    int node, weight ;
    Pair(int node, int weight)
    {
        this.node = node ;
        this.weight = weight ;
    }
}
