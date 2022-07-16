 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		return construct(preOrder, 0, preOrder.length-1) ;
	}

    public static TreeNode<Integer> construct(int[] preorder, int start, int end)
    {
        if (start > end)
            return null ;
        
        TreeNode<Integer> node = new TreeNode(preorder[start]) ;
        
        int split = start+1 ;
        
        while (split <= end && preorder[split] < node.data){
            split++ ;
        }
        
        node.left = construct(preorder, start+1, split-1) ;
        node.right = construct(preorder, split, end) ;
        
        return node ;
    }
 
}
