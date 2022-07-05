import java.util.* ;
public class LRUCache
{
    Node head, tail ;
    HashMap<Integer, Pair> map ;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity ;
        head = new Node(-1, null, null) ;
        tail = new Node(-1, null, head) ;
        head.next = tail ;
        map = new HashMap<>() ;
    }
    
    public int get(int key) {
        
        if (map.containsKey(key)){
            
            Node node = map.get(key).add ;
            Node prev = node.prev ;
            Node next = node.next ;
            prev.next = next ;
            next.prev = prev ;
            
            Node last = tail.prev ;
            last.next = new Node(key, tail, last) ;
            tail.prev = last.next;
            map.put(key, new Pair(map.get(key).val, tail.prev)) ;
            
            return map.get(key).val ;
        }
        return -1 ;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            Node node = map.get(key).add ;
            Node prev = node.prev ;
            Node next = node.next ;
            prev.next = next ;
            next.prev = prev ;
            map.remove(key) ;
        }
        
        if (map.size() == capacity){
            int k = head.next.val ;
            map.remove(k) ;
            head.next.next.prev = head ;
            head.next = head.next.next ;
        }
        
        Node last = tail.prev ;
        last.next = new Node(key, tail, last) ;
        tail.prev = last.next;
        map.put(key, new Pair(value, tail.prev)) ;
    }
}

class Node{
    int val ;
    Node next, prev ;
    Node(int val, Node next, Node prev)
    {
        this.val = val ;
        this.next = next ;
        this.prev = prev ;
    }
}

class Pair{
    Node add;
    int val ;
    Pair(int val, Node add)
    {
        this.add = add ;
        this.val = val ;
    }
}

 
