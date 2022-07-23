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
    
  static boolean isCycle(ArrayList<Integer>[] graph, int n)
  {
       
        int[] indegree = new int[n+1] ;
        
        for (int i = 1; i <= n; i++)
        {
            for (int nbr: graph[i])
            {
                indegree[nbr]++ ;
            }
        }
        
        Queue<Integer> q = new  LinkedList<>() ;    
        for (int i = 1 ; i <=  n; i++)
        {
            if (indegree[i] == 0){
                q.offer(i) ;
            }
        }
        
        int visitedNodes = 0 ;
        
        while(!q.isEmpty())
        {
            int curr = q.poll() ;
            
            visitedNodes++ ;
            
            for (int nbr: graph[curr])
            {
                indegree[nbr]-- ;
                if (indegree[nbr] == 0)
                {
                    q.offer(nbr) ;
                }
            }
        }
        
        return visitedNodes != n ;
        
  }
    
  
}
