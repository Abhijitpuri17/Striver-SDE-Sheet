import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        ArrayList<Pair>[] adj = new ArrayList[n+1] ;
        
        for (int i = 0 ; i <= n; i++)
        {
            adj[i] = new ArrayList<>() ;
        }
        
        for (ArrayList<Integer> edge: g)
        {
            int u = edge.get(0) ;
            int v = edge.get(1) ;
            int w = edge.get(2) ;
            
            adj[u].add(new Pair(v, w)) ;
            adj[v].add(new Pair(u, w)) ;
        }
        
        int[] dist = new int[n+1] ;
        boolean[] mst = new boolean[n+1] ;
        int[] parent = new int[n+1] ;        
        
        Arrays.fill(dist, Integer.MAX_VALUE) ;
        Arrays.fill(parent, -1) ;
        
        dist[0] = Integer.MIN_VALUE ;
        dist[1] = 0 ;
      
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->{
            return p1[1] - p2[1] ;
        }) ;
        
        pq.add(new int[]{1 , 0}) ;
        
        while(!pq.isEmpty()){
            int[] front = pq.poll() ;
            
            int u = front[0] ;
          
            mst[u] = true ;
            
            for (Pair nbr: adj[u])
            {
                //System.out.println(nbr.node + " "+ nbr.weight+ " " + u) ;
                if (mst[nbr.node] == false && nbr.weight < dist[nbr.node])
                {
                    parent[nbr.node] = u ;
                    dist[nbr.node] = nbr.weight ;
                    pq.add(new int[]{nbr.node, dist[nbr.node]}) ;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        for (int i = 2 ; i < parent.length; i++)
        {
            //System.out.println(i +" "+ parent[i] + " "+ dist[i]) ;
                int u = i ;
                int v = parent[i] ;
                int w = dist[i] ;
                
                ArrayList<Integer>  curr = new  ArrayList<>() ;
                curr.add(v) ;
                curr.add(u) ;
                curr.add(w) ;
                
                ans.add(curr) ;
        }

        return ans ;
        
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
