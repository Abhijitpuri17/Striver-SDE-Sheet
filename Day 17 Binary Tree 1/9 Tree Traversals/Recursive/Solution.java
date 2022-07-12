/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.* ;
public class Solution 
{
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root)
    {
        List<List<Integer>> ans = new ArrayList<>() ;
        for (int  i = 0 ; i < 3; i++)
           ans.add(new ArrayList<>()) ;
        
        traverse(ans, root) ;
        return ans;
    }
    
    private static void traverse(List<List<Integer>> ans, BinaryTreeNode<Integer> node)
    {
        if  (node == null) 
            return ;
        
        ans.get(1).add(node.data) ;
        traverse(ans, node.left);
        ans.get(0).add(node.data) ;
        traverse(ans, node.right) ;
        ans.get(2).add(node.data) ;
    }
    
}
