/************************************************************

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

************************************************************/

public class Solution 
{
    public static int floorInBST(TreeNode<Integer> root, int X) 
    {
        TreeNode<Integer> node = root;
        
        int ans = -1 ;
        
        while (node != null)
        {
            if (node.data == X){
                ans  = X;
                break ;
            } else
            if (node.data > X){
                node = node.left ;
            } else {
                ans = node.data ;
                node = node.right ;
            }
        }
        
        return ans ;
    }
}
