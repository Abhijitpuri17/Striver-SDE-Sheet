import java.util.* ;
public class Trie {
    
    static Node head ;
    
    public Trie() {
        head = new Node(' ') ;
    }

    public void insert(String word) {
        Node curr = head ;
        
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
            {
                curr.map.put(ch, new Node(ch)) ;
                curr = curr.map.get(ch) ;
            }
            else
            {
                curr = curr.map.get(ch) ;
                curr.freqPrefix++  ;
            }
        } 
        
        curr.freqEnd++ ;
        curr.isLast = true ;
    }

    public int countWordsEqualTo(String word) 
    {
        Node curr = head ;
       
        for (int i = 0 ; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
                return 0 ;
            
            curr = curr.map.get(ch) ;
        }
   
        if (curr.isLast == false)
            return 0 ;
        
        return curr.freqEnd ;
    }

    public int countWordsStartingWith(String word) {
        Node curr = head ;
       
        for (int i = 0 ; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
                return 0 ;
            
            curr = curr.map.get(ch) ;
        }
        
        return curr.freqPrefix ;
    }

    public void erase(String word) {
        Node curr = head ;
        
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
            {
                return ;
            }
            else
            {
                curr = curr.map.get(ch) ;
                curr.freqPrefix--  ;
            }
        } 
        
        curr.freqEnd-- ;
        curr.isLast = false ;
    }

}

class Node{
    char ch ;
    HashMap<Character, Node> map ;
    boolean isLast ;
    int freqPrefix ;
    int freqEnd ;
    
    Node(char ch)
    {
        this.ch = ch ;
        this.map = new HashMap<>() ;
        this.isLast = false;
        this.freqPrefix = 1 ;
        this.freqEnd = 0 ;
    }
    
}
