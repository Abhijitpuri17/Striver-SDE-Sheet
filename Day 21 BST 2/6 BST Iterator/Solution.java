/*
    Definition of Node class for reference

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

*/
import java.util.* ;
public class Solution {

    static class BSTIterator{

        ArrayList<Integer> in ;
        int pos = -1 ;
        
        BSTIterator(TreeNode<Integer> root){
            in = new ArrayList<>() ;
            inorder(root, in) ;
            pos = -1 ;
        }
        
        
        static void inorder(TreeNode<Integer> node, ArrayList<Integer> in)
        {
            if (node == null)
                return ;
            
            inorder(node.left, in) ;
            in.add(node.data) ;
            inorder(node.right, in) ;
        }

        int next(){
            pos++ ;
            return in.get(pos) ;
        }

        boolean hasNext(){
            return pos + 2 <= in.size() ;
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
