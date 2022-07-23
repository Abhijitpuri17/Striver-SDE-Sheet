import java.util.*;
public class Solution 
{
    
    public static boolean dfs(ArrayList<Integer>[] graph, int node, int parent, boolean[] visited)
    {
        visited[node] = true ;
        
        for (int nbr: graph[node])
        {
            if (!visited[nbr])
            {
                boolean sub = dfs(graph, nbr, node, visited) ;
                if (sub)
                    return true ;
            } else if (nbr != parent) return true ;
        }
        
        return false ;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) 
    {
        ArrayList<Integer>[] graph = new ArrayList[n+1] ;
        
        for (int i = 0 ; i <= n ; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge: edges)
        {
            graph[edge[0]].add(edge[1]) ;
            graph[edge[1]].add(edge[0]) ;
        }
        
        boolean[] visited = new boolean[n+1] ;
        
        for (int i = 1; i <= n ; i++)
        {
            if (!visited[i])
            {
                boolean sub = dfs(graph, i, i, visited) ;
                if (sub)
                    return "Yes" ;
            }
        }
        
       return "No" ;
    }
    
}

