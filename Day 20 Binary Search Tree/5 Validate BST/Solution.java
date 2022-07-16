/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution 
{
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return check(root, (long)-1e9-1, (long)1e9+1);
    }
    
    public static boolean check(BinaryTreeNode<Integer> node, long min, long max)
    {
        if (node == null)
            return true ;
        
        if (node.data < min || node.data > max)
            return false ;
        
        return check(node.left, min, node.data) && check(node.right, node.data, max) ;
        
    }
    
}
