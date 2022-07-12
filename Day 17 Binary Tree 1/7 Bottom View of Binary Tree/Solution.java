/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/

import java.util.* ;
public class Solution
{

    public static ArrayList<Integer> bottomView(BinaryTreeNode root) 
    {
        TreeMap<Integer, Integer>  map = new TreeMap<>() ;
        
        Queue<Pair> q = new LinkedList<>() ;
        
        q.add(new Pair(root, 0)) ;
        
        while (!q.isEmpty())
        {
            Pair p = q.poll() ;
           
            BinaryTreeNode curr = p.node ;
            
            map.put(p.dist, curr.val) ;
            
            if (curr.left != null)
            {
                q.add(new Pair(curr.left, p.dist-1)) ;
            }
            
            if (curr.right != null)
            {
                q.add(new Pair(curr.right, p.dist + 1)) ;
            }
        }
        
        ArrayList<Integer> bottomView = new ArrayList<>()  ;
        
        for (int val : map.values())
            bottomView.add(val) ;
        
        return bottomView ;
    }
}

class Pair{
    BinaryTreeNode node;
    int dist ;
    
    Pair(BinaryTreeNode node, int dist)
    {
        this.node = node ;
        this.dist = dist ;
    }
}
