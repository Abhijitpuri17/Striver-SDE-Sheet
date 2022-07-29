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
        
        dist[1] = 0 ;
      
        
        for (int i = 0 ; i < n-1; i++)
        {
            int min = Integer.MAX_VALUE ;
            int u = 1 ;
            
            for (int v = 1 ; v <= n; v++)
            {
                if (mst[v] == false && dist[v] < min)
                {
                    min = dist[v] ;
                    u = v ;
                }
            }
            
            mst[u] = true ;
            
            for (Pair nbr: adj[u])
            {
                //System.out.println(nbr.node + " "+ nbr.weight+ " " + u) ;
                if (mst[nbr.node] == false && nbr.weight < dist[nbr.node])
                {
                    
                    parent[nbr.node] = u ;
                    dist[nbr.node] = nbr.weight ;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        for (int i = 1 ; i <= n; i++)
        {
            //System.out.println(i +" "+ parent[i] + " "+ dist[i]) ;
            if (parent[i] != -1)
            {
                int u = i ;
                int v = parent[i] ;
                int w = dist[i] ;
                
                ArrayList<Integer>  curr = new  ArrayList<>() ;
                curr.add(u) ;
                curr.add(v) ;
                curr.add(w) ;
                
                ans.add(curr) ;
 
            }
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
