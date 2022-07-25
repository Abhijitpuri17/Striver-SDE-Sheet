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
                Queue<Integer> q = new LinkedList<>() ;
               
                colors[node] = 0 ;
                q.add(node) ;
                
                while (!q.isEmpty())
                {
                    int p = q.poll() ;
              
                    for (int nbr: graph.get(p))
                    {
                        if (colors[nbr] == -1)
                        {
                            colors[nbr] = 1 - colors[p] ;
                            q.add(nbr) ;
                        }
                        else if (colors[nbr] != 1 - colors[p])
                        {
                            return false ;
                        }
                    }
                }
         
            }
        }
        
        
        return true ;
    }
}

