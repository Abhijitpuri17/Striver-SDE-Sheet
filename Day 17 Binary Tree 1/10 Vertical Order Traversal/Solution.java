/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        Queue<Pair> q = new LinkedList<>() ;
        
        q.add(new Pair(root, 0)) ;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>() ;
        
        while (!q.isEmpty())
        {
            Pair p = q.poll() ;
            if (!map.containsKey(p.dist))
            {
                map.put(p.dist, new ArrayList<>()) ;
            }
            map.get(p.dist).add(p.node.data) ; 
            
            if (p.node.left != null){
                q.add(new Pair(p.node.left, p.dist-1)) ;
            }
            
            if (p.node.right != null){
                q.add(new Pair(p.node.right, p.dist+1)) ;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for (ArrayList<Integer> list : map.values())
        {
            for (int x: list)
                ans.add(x) ;
        }
        
        return ans ;
    }
}

class Pair{
    TreeNode<Integer> node ;
    int dist ;
 
    Pair(TreeNode<Integer> node, int dist)
    {
        this.node = node ;
        this.dist = dist ;
    }
    
}
