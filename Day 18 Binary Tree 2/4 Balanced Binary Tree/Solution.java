/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) 
    {
        return height(root) != -1;
	}
    
    static int height(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return 0 ;
        
        int leftHeight = height(node.left) ;
        int rightHeight = height(node.right) ;
        
        if (leftHeight == -1 ||  rightHeight == -1)
            return -1 ;
        
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1 ;
        
        return Math.max(leftHeight, rightHeight) + 1 ;
    }
    
}
