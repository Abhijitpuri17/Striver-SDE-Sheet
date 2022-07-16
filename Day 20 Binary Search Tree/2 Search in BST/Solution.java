/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		BinaryTreeNode<Integer> curr = root ;
        
        while (curr != null)
        {
            if (curr.data == x)
                return true ;
            
            if (curr.data <  x){
                curr = curr.right ;
            } else
                curr = curr.left ;
        }
        
       return false ; 
	}
}
