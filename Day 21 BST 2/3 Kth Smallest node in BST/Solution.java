/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution 
{

    static int ans = -1 ;
    static int cnt = 0 ;
    
	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		cnt = 0 ;
        ans = -1 ;
        inorder(root,  k) ;
        return ans ;
	}

    static void inorder(TreeNode<Integer> node, int k)
    {
        if  (node == null)
            return ;
        inorder(node.left, k) ;
        cnt++ ;
        if (cnt == k){
            ans = node.data ;
        }
        inorder(node.right, k) ;
    }
    
}
