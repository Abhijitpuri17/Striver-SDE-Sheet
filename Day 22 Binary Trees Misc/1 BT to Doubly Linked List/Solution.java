
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution 
{
	static BinaryTreeNode<Integer> prev = null ;
    static BinaryTreeNode<Integer> newRoot = null ;
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) 
    {
        prev = null ;
        newRoot = null ;
		inorder(root) ;
        return newRoot ;
	}
	
    public static void inorder(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return ;
        
        inorder(node.left);
        if (prev != null)
        {
            prev.right = node ;
        } else{
            newRoot = node ;
        }

        node.left = prev ;
        
        prev = node ;
        inorder(node.right)  ;
    }
   

}
