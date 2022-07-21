/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/

public class Solution 
{
    static int ans = 0 ;
	public static int largestBST(TreeNode<Integer> root)
    {
        ans = 0 ;
		helper(root) ;
        return ans ;
	}
    
    static Pair helper(TreeNode<Integer> node)
    {
        if (node == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0) ;
        
        Pair left = helper(node.left);
        Pair right = helper(node.right) ;
        
        if (left == null || right == null || left.max >= node.data || right.min <= node.data)
            return null ;
        
        int min = Math.min(node.data, left.min) ;
        int max= Math.max(node.data, right.max) ;
        
        int size = left.size +  right.size + 1 ;
        ans = Math.max(ans, size) ;
      
        return new Pair(min, max, size) ;
    }
    
}

class Pair{
    int min;
    int max ;
    int size ;
    
    Pair(int min, int max, int size)
    {
        this.min = min ;
        this.max = max ;
        this.size = size  ;
    }
}
