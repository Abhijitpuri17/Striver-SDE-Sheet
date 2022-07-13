/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        HashMap<Integer, Integer> parent = new HashMap<>() ;
        
        Queue<TreeNode> q = new LinkedList<>() ;
        if (A != null)
        q.add(A) ;
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll() ;
            if (curr.left != null){
                parent.put(curr.left.val, curr.val) ;
                q.add(curr.left) ;
            }
             if (curr.right != null){
                parent.put(curr.right.val, curr.val) ;
                q.add(curr.right) ;
            }
        }
        
        LinkedList<Integer> ans = new LinkedList<>() ;
        
        while (parent.containsKey(B)){
            ans.addFirst(B) ;
            B = parent.get(B) ;
        }
        ans.addFirst(B) ;
        
        int[] ansArr = new int[ans.size()];
        
        int i = 0 ;
        for  (int x: ans) ansArr[i++] = x ;
        
        return ansArr ;
    }
}
