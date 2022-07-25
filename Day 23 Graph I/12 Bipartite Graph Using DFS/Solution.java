import java.util.*;

public class Solution 
{
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) 
    {
        
        ArrayList<ArrayList<Integer>> graph = new  ArrayList<>() ;
        
        int n = edges.size() ;
        
        for(int i = 0 ; i < n; i++)
        {
            graph.add(new ArrayList<>()) ;
        }
        
        for (int i = 0 ; i < n ; i++)
        {
            for  (int j = 0; j <  n ; j++)
            {
                if (edges.get(i).get(j) == 1)
                {
                    graph.get(i).add(j) ;
                    graph.get(j).add(i) ;
                }
            }
        }
        
        int[] colors = new int[n] ;
        
        for (int i = 0 ; i < n; i++)
            colors[i] = -1 ;
        
        for (int node = 0 ; node < n; node++)
        {
            if (colors[node] == -1)
            {
                boolean sub = dfs(graph, node, 0, colors) ;
                if (!sub)
                    return false ;
            }
        }
     
        return true ;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, int toColor, int[] colors)
    {
        if (colors[node] == 1 - toColor)
            return false ;
        
        colors[node] = toColor ;
        
        for (int nbr: graph.get(node))
        {
            if (colors[nbr] == 1 - colors[node])
                continue ;
            
            if (colors[nbr] == colors[node])
                return false ;
            
            boolean  sub = dfs(graph, nbr, 1 - colors[node], colors) ;
            
            if  (!sub)
                return false ;
        }
        
        return true ;
    }
    
    
}

