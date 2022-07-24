import java.util.* ;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<Integer>[] graph = new ArrayList[v] ;
        
        for (int i = 0 ; i < v; i++)
        {
            graph[i] = new ArrayList<>() ;
        }
        
        for (ArrayList<Integer> edge: edges)
        {
            graph[edge.get(0)].add(edge.get(1)) ;
        }
        
        Stack<Integer> stack = new Stack<>() ;
        boolean[] visited = new boolean[v] ;
        
        for (int i = 0; i < v; i++)
        {
            if (!visited[i])
            {
                dfs(graph, stack, i, visited) ;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        while (!stack.isEmpty())
        {
            ans.add(stack.pop()) ;
        }
        
        return ans ;
    }
    
    static void dfs(ArrayList<Integer>[] adj, Stack<Integer> stack, int node,
                   boolean[] visited)
    {
        visited[node] = true ;
        
        for (int nbr: adj[node])
        {
            if (!visited[nbr])
            {
                dfs(adj, stack, nbr, visited) ;
            }
        }
        
        stack.push(node) ;
        
    }
    
    
}
