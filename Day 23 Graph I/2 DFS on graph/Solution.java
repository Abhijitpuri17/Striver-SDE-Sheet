import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) 
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        ArrayList<Integer>[] graph = new ArrayList[v] ;
        
        for (int i = 0 ; i < v; i++)
        {
            graph[i] = new ArrayList<>() ;
        }
        
        for (ArrayList<Integer> edge: edges)
        { 
            graph[edge.get(0)].add(edge.get(1)) ;
            graph[edge.get(1)].add(edge.get(0)) ;
        }
                
        boolean[] visited = new boolean[v] ;
        Arrays.fill(visited,  false) ;
        for (int i = 0; i < v; i++)
        {
            if (!visited[i])
            {
                ArrayList<Integer> curr = new ArrayList<>() ;
                dfs(graph, i, curr, visited) ;
                ans.add(curr) ;
            }
        }
       
        return ans ;
    }
    
    public static void dfs(ArrayList<Integer>[] graph, int node, ArrayList<Integer> curr, boolean[] visited)
    {
        visited[node] = true ;
        curr.add(node) ;
        for (Integer nbr: graph[node])
        {
            if (!visited[nbr])
            dfs(graph, nbr, curr, visited) ;
        }
    }
    
}
