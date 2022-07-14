/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

import java.util.* ;
public class Solution 
{
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root)
    {
        List<Integer> ans = new ArrayList<>() ;
        Queue<BinaryTreeNode> q = new LinkedList<>() ;
  
        if (root != null)
        q.add(root) ;
        boolean f = true ;
      
        while (!q.isEmpty())
        {
            int size = q.size() ;
            LinkedList<Integer> curr = new LinkedList<>() ;
            for (int i = 0 ; i < size; i++)
            {
                BinaryTreeNode<Integer> node = q.poll() ;
                if (f)
                    curr.addLast(node.data) ;
                else
                    curr.addFirst(node.data) ;
                
                if (node.left != null)
                    q.add(node.left) ;
                
                if (node.right != null)
                    q.add(node.right) ;
            }
            f = !f ;
            
            for (int x: curr)
                ans.add(x) ;            
        }
        
      return ans ;  
	}
}
