import java.util.* ;
class Solution 
{

  public static String completeString(int n, String[] a) 
  {
      Trie t = new Trie() ;
      
      Arrays.sort(a, (s1, s2)->{
          if (s1.length() == s2.length())
              return s2.compareTo(s1) ;
          
          return s1.length() - s2.length() ;
      }) ;
      
      String ans = "None" ;
           
      for (String word: a)
      {
         if (t.insert(word)){
             ans = word ;
         } 
      }
      
      return ans ;
  }
}

class Trie {
 
    static Node head ;
  
    Trie() {
        head = new Node(' ') ;
    }

    public static boolean insert(String word) {
        Node curr = head ;
 
        boolean flag = true ;
        
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i) ;
            if (!curr.map.containsKey(ch))
            {
                curr.map.put(ch, new Node(ch)) ;
            }
            curr = curr.map.get(ch);
            if (curr.isLast == false && i != word.length() - 1){
                flag = false ;
            }
        } 
    
        curr.isLast = true ;
        return flag ;
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

