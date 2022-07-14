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

import java.util.*;

public class Solution 
{
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        
        for (int i = 0; i < inorder.size(); i++)
        {
            map.put(preorder.get(i), i) ;
        }
        
        return helper(inorder, map, 0, inorder.size()-1) ;
    }
    
    public static TreeNode helper(ArrayList<Integer> in, HashMap<Integer, Integer> map, int start, int end)
    {
        if (start > end)
            return null ;
        
        int inIndex = start ;
        
        for (int i = start+1; i <= end; i++)
        {
            if (map.get(in.get(i)) < map.get(in.get(inIndex)))
                inIndex = i ;
        }
        
        TreeNode node = new TreeNode(in.get(inIndex)) ;
        node.left = helper(in, map, start, inIndex-1) ;
        node.right = helper(in, map, inIndex+1, end) ;
        
        return node ;
    }
    
    
}
