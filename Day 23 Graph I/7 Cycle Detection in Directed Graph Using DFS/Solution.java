import java.util.*;
public class Solution 
{
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges)
  {
    ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i = 1 ; i <=  n; i++)
        {
            graph[i] = new ArrayList<>() ;
        }
        
        for (ArrayList<Integer> edge: edges)
        {
            graph[edge.get(0)].add(edge.get(1)) ;
        }
        
       return isCycle(graph, n) ;
  }
    
  static boolean dfs(ArrayList<Integer>[] graph, int node, boolean[] visited, boolean[] dfsVisited)
  {
      visited[node] = true ;
      dfsVisited[node] = true ;

      for (int nbr: graph[node])
      {
        if (!visited[nbr])
        {
          boolean sub = dfs(graph, nbr, visited, dfsVisited) ;
          if (sub) 
            return true;
        }
        else if (dfsVisited[nbr])
          return true ;
      }

      dfsVisited[node] = false ;
      return false ;
  }
    
    static boolean isCycle(ArrayList<Integer>[] graph, int n)
    {
        boolean[] visited = new boolean[n+1] ;
        boolean[] dfsVisited = new boolean[n+1] ;
        for (int i = 1; i <= n; i++)
        {
            if (!visited[i])
            {
                boolean sub = dfs(graph, i, visited, dfsVisited) ;
                if (sub)
                    return true ;
            }
        }
        
        return false ;
    }
    
}
