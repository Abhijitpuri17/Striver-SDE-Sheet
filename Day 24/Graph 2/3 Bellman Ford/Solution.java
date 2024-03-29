import java.util.*;

public class Solution {

   static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) 
   {
      int dist[] = new int[n+1];
       
      Arrays.fill(dist, 1000000000);

      dist[src] = 0;

      for(int j = 1; j <= n-1; j++)
      {
           for(ArrayList<Integer> it:edges)
           {
               int u=it.get(0);
               int v=it.get(1);
               int wt=it.get(2);
               if(dist[u]!=1e9)
               helper(u,v,wt,dist);
           }
      }

      return dist[dest];
   }
    
    public static void helper(int u,int v,int wt,int[]dist)
    {
        if(dist[u] + wt < dist[v])
        {
            dist[v] = dist[u] + wt ;
        }
    }
}
