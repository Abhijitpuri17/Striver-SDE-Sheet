import java.util.* ;
public class Solution 
{
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) 
    {
        Collections.sort(graph, (a1, a2) ->{
            return a1.get(2) - a2.get(2) ;
        }) ;
        
        DisjointSet ds = new DisjointSet(n) ;
        
        int ans = 0 ;
        
        for (ArrayList<Integer> edge : graph)
        {
            if (!ds.areJoint(edge.get(0), edge.get(1)))
            {
                ans += edge.get(2) ;
                ds.union(edge.get(0), edge.get(1)) ;
            }
        }
        
        return ans ;
    }
}

class DisjointSet{
    
    int[] parent ;
    int[] rank ;
    int n ;
    
    public DisjointSet(int n)
    {
        this.n = n ;
        parent = new int[n+1] ;
        rank = new int[n+1] ;
        
        for (int i = 0 ; i <= n ; i++)
        {
            parent[i] = i ;
        }
        
    }
    
    int findParent(int node)
    {
        if (parent[node] == node)
            return node ;
        
        return parent[node] = findParent(parent[node]) ;
    }
    
    void union(int u, int v)
    {
        int par1 = findParent(u) ;
        int par2 = findParent(v) ;
        
        if (rank[par1] < rank[par2]){
            parent[par1] = par2 ;
        } else if (rank[par2] < rank[par1])
        {
            parent[par2] = par1 ;
        } else{
            parent[par1] = par2 ;
            rank[par2]++ ;
        }
        
    }
    
    boolean areJoint(int u, int v)
    {
        return findParent(u) == findParent(v) ;
    }
    
    
}
