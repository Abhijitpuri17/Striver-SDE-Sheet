import java.util.*;
public class Solution 
{
    
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
        
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1] ;
        
        for (int i = 1; i <= n ; i++)
        {
            if (!visited[i])
            {
                q.offer(new Pair(i, i)) ;
                visited[i]  = true ;
                
                while (!q.isEmpty())
                {
                    Pair node = q.poll() ;
                    for (int nbr: graph[node.node])
                    {
                        if  (!visited[nbr])
                        {
                            visited[nbr] = true ;
                            q.add(new Pair(nbr, node.node)) ;
                        }
                        else
                        if (node.parent != nbr)
                            return "Yes" ;
                    }
                }
                
            }
        }
        
       return "No" ;
        
    }
    
}

class Pair{
    int node ;
    int parent ;
    
    Pair(int node, int parent)
    {
        this.node = node ;
        this.parent = parent ;
    }
    
}
