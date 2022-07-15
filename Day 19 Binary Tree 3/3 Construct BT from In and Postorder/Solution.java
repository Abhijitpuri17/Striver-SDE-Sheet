/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/
import java.util.* ;
public class Solution 
{
	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) 
    {
		HashMap<Integer, Integer> map = new HashMap<>() ;
        
        for (int i = 0 ; i <  postOrder.length; i++)
        {
            map.put(postOrder[i], i) ;
        }
        
        return construct(inOrder, map, 0, inOrder.length-1) ;
	}
    
    static TreeNode construct(int[] in, HashMap<Integer, Integer> map, int start, int end)
    {
        if (start > end)
            return null ;
        
        int inIndex = end ;
        
        for (int i = start; i < end; i++){
            if (map.get(in[inIndex]) < map.get(in[i])){
                inIndex = i ;
            }
        }
        
        TreeNode<Integer> node = new TreeNode(in[inIndex]) ;
        
        node.left = construct(in,  map, start, inIndex-1) ;
        node.right  = construct(in, map, inIndex+1, end) ;
        
        return node ;
        
    }
    
    
}
