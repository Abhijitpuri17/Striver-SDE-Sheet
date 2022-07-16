/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution 
{

	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
       if (p.data >  q.data){
            TreeNode temp  = p ;
            p = q ;
            q = temp ;
        }
        
        TreeNode<Integer> curr = root ;
        TreeNode<Integer> lca = null ;
        
        while (curr != null)
        {
            if (curr.data > q.data){
                curr = curr.left ;
            }
            else if (curr.data < p.data){
                curr = curr.right ;
            }
            else{
                lca = curr ;
                break ;
            }
        }
        
        return lca ;
	}
}
