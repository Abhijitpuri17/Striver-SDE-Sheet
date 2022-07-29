import java.util.* ;
public class Solution
{
    public static int distinctSubstring(String word)
    {
        Node head = new Node(' ') ;
        
        int cnt = 0 ;
        
        int n = word.length() ;
        
        for (int i = 0 ; i < n; i++)
        {
            Node node = head ;
            for(int  j = i; j < n; j++)
            {
                if (!node.map.containsKey(word.charAt(j)))
                {
                    node.map.put(word.charAt(j), new Node(word.charAt(j))) ;
                    cnt++ ;
                }
                node = node.map.get(word.charAt(j));
            }
        }
        
        return cnt;
    }
}

class Node{
    char ch ;
    HashMap<Character, Node> map ;
    boolean isLast ;
    
    Node(char ch)
    {
        this.ch = ch ;
        this.map = new HashMap<>() ;
        this.isLast = false;
    }
    
}
