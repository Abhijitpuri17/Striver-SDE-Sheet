import java.util.* ;
public class Solution 
{
    public static ArrayList<Integer> BFS(int vertex, int edges[][])
    {
        ArrayList<Integer>[] graph = new ArrayList[vertex] ;
        for (int i = 0 ; i < vertex; i++)
        {
            graph[i] = new ArrayList<>() ;
        }
        
        for (int i = 0 ; i < edges[0].length; i++)
        {
            graph[edges[0][i]].add(edges[1][i]) ;
            graph[edges[1][i]].add(edges[0][i]) ;
        }
        
        for (int i = 0 ; i < vertex; i++)
        {
            Collections.sort(graph[i]) ;
        }
        
       
        boolean[] visited = new boolean[vertex] ;
        ArrayList<Integer> bfs = new ArrayList<>() ;
        
        for (int i = 0 ; i < vertex; i++)
        {
            if (visited[i])
                continue ;
            Queue<Integer> q = new LinkedList<>() ;
            q.add(i) ;
            visited[i] = true ;

            while (!q.isEmpty())
            {
                int curr  = q.poll() ;
                bfs.add(curr) ;

                for(int nbr: graph[curr])
                {
                    if (!visited[nbr])
                    {
                        visited[nbr] = true ;
                        q.add(nbr) ;
                    }
                }
            }
        }
        return bfs ;
    }
}

