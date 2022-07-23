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
        
        int[] indegree = new int[v] ;
        
        for(int node = 0 ; node < v; node++)
        {
            for (int nbr: graph[node])
            {
                indegree[nbr]++ ;
            }
        }
        
        Queue<Integer> q = new LinkedList<>() ;
        
        for (int node = 0 ; node < v; node++)
        {
            if  (indegree[node] == 0)
                q.offer(node) ;
        }
        
        ArrayList<Integer> topoSortList = new ArrayList<>() ;
        
        while (!q.isEmpty())
        {
            int curr = q.poll() ;
            topoSortList.add(curr) ;
            
            for (int nbr: graph[curr])
            {
                indegree[nbr]-- ;
                
                if(indegree[nbr] == 0)
                    q.offer(nbr) ;
            }  
        }
        
        return topoSortList ;
    }
}
