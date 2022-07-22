/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
import java.util.* ;
public class Solution 
{
    
    public static void dfs(graphNode node, graphNode copy, HashMap<graphNode, graphNode> map)
    {
        map.put(node, copy) ;
        
        for (graphNode nbr: node.neighbours)
        {
            if (!map.containsKey(nbr)){
                map.put(nbr, new graphNode(nbr.data));
                dfs(nbr,  map.get(nbr), map) ;
            }
            copy.neighbours.add(map.get(nbr)) ;
        }
    }
    
    public static graphNode cloneGraph(graphNode node)
    {
        if (node == null)
            return null ;
        
        HashMap<graphNode, graphNode> map = new HashMap<>() ; 
        graphNode copy = new graphNode(node.data) ;
        dfs(node, copy, map) ;
        
        return copy ;
    }
}
