/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution 
{

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) 
    {
       if (root == null)
            return true ;
        
       return helper(root.left, root.right) ;
    }
    
    public static boolean helper(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2)
    {
        if (node1 == null && node2 == null)
            return true ;
        
        if (node1 == null || node2 == null)
            return false ;
        
        if (!node1.data.equals(node2.data))
            return false ;
        
        return helper(node1.left, node2.right) && helper(node2.left, node1.right) ;
    }
    
}
