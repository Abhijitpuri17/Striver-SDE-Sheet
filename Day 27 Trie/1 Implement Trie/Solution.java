import java.util.* ;
public class Trie {
 
    static Node head ;
    
    Trie() {
        head = new Node(' ') ;
    }

    public static void insert(String word) {
        Node curr = head ;
        
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
            {
                curr.map.put(ch, new Node(ch)) ;
            }
            curr = curr.map.get(ch) ;
        } 
        
        curr.isLast = true ;
    }


    public static boolean search(String word) {
        Node curr = head ;
       
        for (int i = 0 ; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
                return false ;
            
            curr = curr.map.get(ch) ;
        }
        
        return curr.isLast ;
    }

    public static boolean startsWith(String prefix) 
    {
        Node curr = head ;
       
        for (int i = 0 ; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i) ;
            if (!curr.map.containsKey(ch))
                return false ;
            
            curr = curr.map.get(ch) ;
        }
        
        return true ;
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


