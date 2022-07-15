/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution 
{
    public static void changeTree(BinaryTreeNode < Integer > root) 
    {
        change(root) ;
    }
    
    public static int change(BinaryTreeNode<Integer> node)
    {
        if(node == null)
            return 0 ;
        
        if (node.left == null && node.right == null)
            return node.data ;
        
        int childSum = 0 ;
        
        if (node.left != null)
            childSum += node.left.data ;
        
        if (node.right != null)
            childSum += node.right.data ;
        
        if (childSum < node.data){
            if (node.left != null){
                node.left.data =node.data ;
            } else if (node.right != null){
                node.right.data = node.data ;
            }
        }
        
        int left = change(node.left) ;
        int right = change(node.right) ;
        
        node.data = left + right ;
        
        return node.data ;
    }
    
}
