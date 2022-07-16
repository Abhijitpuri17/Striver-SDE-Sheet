/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/
import java.util.Queue;
import java.util.LinkedList ;
public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	Queue<BinaryTreeNode<Integer>>  q = new LinkedList<>() ;
        
        if (root != null)
            q.add(root) ;
        
        while (!q.isEmpty())
        {
            int size = q.size() ;
            
            for (int i = 0 ; i < size; i++)
            {
                BinaryTreeNode<Integer> node = q.poll() ;
                if (i != size - 1){
                    node.next = q.peek() ;
                }
                
                if (node.left != null)
                    q.add(node.left) ;
                
                if (node.right != null)
                    q.add(node.right) ;
            }
        }
   
	}
}
