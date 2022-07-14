/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution 
{
  static int diameter = 0 ;
	public static int diameterOfBinaryTree(TreeNode<Integer> root) 
  {
        diameter = 0 ;
		    height(root) ;
        return diameter ;
	}
    
  public static int height(TreeNode<Integer> node)
  {
      if (node == null)
        return 0 ;
        
      int leftHeight = height(node.left) ;
      int rightHeight = height(node.right) ;
        
      diameter = Math.max(diameter, leftHeight + rightHeight) ;
        
     return Math.max(leftHeight, rightHeight) + 1 ;
  }
    
}
